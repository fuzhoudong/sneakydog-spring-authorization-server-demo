package dog.sneaky.demo.controllers;


public abstract class BaseController {

    protected String redirect(String path){
        return "redirect:" + path;
    }

    protected String forward(String path){
        return "forward:" + path;
    }
}
