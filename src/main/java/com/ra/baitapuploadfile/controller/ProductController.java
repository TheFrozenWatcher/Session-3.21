package com.ra.baitapuploadfile.controller;

import com.ra.baitapuploadfile.dto.ProductDto;
import com.ra.baitapuploadfile.entity.ImageProduct;
import com.ra.baitapuploadfile.entity.Product;
import com.ra.baitapuploadfile.service.IProductImageService;
import com.ra.baitapuploadfile.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProductController
{
    private final IProductService productService;
    private final IProductImageService productImageService;

    @Autowired
    public ProductController(IProductService productService, IProductImageService productImageService)
    {
        this.productService = productService;
        this.productImageService = productImageService;
    }

    @GetMapping({"/", "/list"})
    public String list(Model model)
    {
        model.addAttribute("products", productService.findAll());
//        model.addAttribute("productImages", productImageService.findAll());
        return "list";
    }

    @GetMapping("/initAdd")
    public String viewAdd(Model model)
    {
        model.addAttribute("product", new ProductDto());
//        model.addAttribute("images", new ImageProduct());
        return "add";
    }

    @PostMapping("/add")
    public String addProduct(@Validated @ModelAttribute("product") ProductDto productDto, BindingResult result, Model model, HttpServletRequest request)
    {
        if (result.hasErrors())
        {
            model.addAttribute("product", productDto);
            return "add";
        } else
        {
            productService.save(productDto, request);
            return "redirect:/list";
        }
    }

    @GetMapping("/initEdit/{id}")
    public String viewEdit(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editProduct(@Validated @ModelAttribute("product") ProductDto productDto, BindingResult result, Model model, HttpServletRequest request)
    {
        if (result.hasErrors())
        {
            model.addAttribute("product", productService.findById(productDto.getId()));
//            model.addAttribute("product", productDto);
            return "edit";
        } else
        {
            productService.save(productDto, request);
            return "redirect:/list";
        }
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id)
    {
        productService.delete(id);
        return "redirect:/list";
    }
}
