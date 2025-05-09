package vn.com.t3h.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
@Controller:
    - đánh dấu cho spring biet đây là tầng controller và cần được tạo bean trong spring container
    - Trả về giao diện HTML qua thư viện JSP

    - Bean trong spring: tất cả các object thay vì dev phải chủ động tạo đối tượng bằng từ khóa new
    thì khi sử dụng các annotaion @Component, @Service, @Controller, @Repository
    -> spring sẽ tự động sử dụng cơ chết IOC để tạo ra các bean và sử dụng cơ chế DI tiêm các bean vào
    trong các class cha

    - @Component, @Service, @Controller, @Repository :
        tất cả các annoation này về bản chất không khác nhau vì đều cùng để đánh đáu giúp tạo ra bean
        - khi có tên khác nhau sẽ giúp phân tách các tầng xử lý logic riêng trong project
        - @Controler -> pakcage controller:
            + chỉ sử dụng ở tầng controller, nơi tiếp nhận cc request, param, và trả về các response cho client
        - @Service -> package service:
            + chỉ định đó là tầng xử lý nghiệp vụ logic của chức năng,
            + tầng này sẽ tiếp nhận các param, và requst từ controller và gọi tới tầng repository để thao tác với dữ liệu
       - @Repository -> package dao, spring boot -> package repository:
            + đánh dấu đây là tầng chuyên thao tác với dữ liệu, giao tiếp với các cơ sở dữ liệu
            + tạo ra các câu query và query vào trong database để trả ra dữ liệu cho tầng service

      - cấu trúc project
        + package controller:
            chứa các file class controller có các method tiếp nhận requst, trả về response
            package này sẽ sử dụng các class tại package service
        + package service:
            chứa các file class xử lý logic của chức năng
            tiếp nhận cc request và gọi tới các class package dao để giao tiếp với database
        + package dao | repository
            chứa các file interface hoạc class chuyên sử dụng để giao tiếp với database
            package này được tầng service gọi tơi
        + model | dto (data transfer object)
            chứa tất cả cac class model | dto được sử dụng để lưu trữ dữ liệu phục vụ quá trình
            xử lý v truyền tải tại tất cả các tầng controller, service, repository trong project
            vd: dữ liệu được trả ra trong database sẽ được class trong package này tiếp nhận và tạo
            ra các đối tượng để các tầng service, controller xử lý

 */
@Controller
public class HomeController {

    /*
    @GetMapping => method Get HTTP
    @PostMapping => method POST HTTP
    @PutMapping => method PUT HTTP
     @DeletedMapping => method Delete HTTP

     /home: -> method này sẽ được xử dụng để xử lý request với url localhost:8080/home
     */
    @GetMapping("/home")
    public String home() {
        return "home";
    }

}
