package com.tarking.controller;

import com.tarking.entity.Advertiser;
import com.tarking.entity.Book;
import com.tarking.repository.ReadlingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tuojinguo on 2018/3/6.
 */
@Controller
@RequestMapping("/")
public class ReadingListController {

    private ReadlingListRepository readlingListRepository;

    @Bean
    private Advertiser advertiser(){
        return new Advertiser();
    }

    //@Autowired
    @Resource
    private Advertiser advertiser;

    @Autowired
    public ReadingListController(ReadlingListRepository readlingListRepository){
        this.readlingListRepository = readlingListRepository;
    }

    //@RequestMapping(name = "{/reader}",method = RequestMethod.GET)
    @GetMapping("/{reader}")
    public String readersBooks(@PathVariable("reader") String reader, Model model){

        List<Book> readingList = readlingListRepository.findByReader(reader);
        if(readingList!=null){
            model.addAttribute("books",readingList);
            model.addAttribute("reader",reader);
            model.addAttribute("amazonID",advertiser.getAssociateId());  //将注入的属性放入模型
        }
        return "readingList";
    }



    //@RequestMapping(name="{/reader}",method = RequestMethod.POST)
    @PostMapping("/{reader}")
    public String addToReadingList(@PathVariable("reader") String reader,Book book){
        book.setReader(reader);
        readlingListRepository.save(book);
        return "redirect:/{reader}";
    }
}
