package testgroup.deficit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import testgroup.deficit.model.*;
import testgroup.deficit.service.substance.SubstanceService;
import testgroup.deficit.service.tov.TOVService;
import testgroup.deficit.service.van.VanService;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;
import java.util.List;

import static testgroup.deficit.service.substance.SubstanceServiceImpl.*;


@Controller
public class VanController {
    int maxRowInPage = 10;
    private final VanService vanService;
    private final SubstanceService substanceService;
    private final TOVService tovService;

    public VanController(VanService vanService, SubstanceService substanceService, TOVService tovService) {
        this.vanService = vanService;
        this.substanceService = substanceService;
        this.tovService = tovService;
    }
    private int pageVanTable;
    private CalculationPost calculationPost;
    private VanTablePost vanTablePost;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainMenuPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("mainPage");
        return modelAndView;
    }

    @RequestMapping(value = "/vanTable", method = RequestMethod.GET)
    public ModelAndView vanTablePage(@RequestParam(defaultValue = "1") int page) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vanTablePage");
        vanService.procedureUpdate();
        this.pageVanTable = page;
        try {
            List<Month> months = new java.util.ArrayList<>(List.of(Month.values()));
            List<Substance> substanceList = allPlusSubstanceList(substanceService.substanceList());
            String substance = "All";
            String typeList = "0";
            String year = new SimpleDateFormat("yyyy").format(new Date());
            String month = new SimpleDateFormat("MM").format(new Date());
            String dateFrom = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String dateTo = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            int maxRowInPage = this.maxRowInPage;
            String[] arrForTypeQuery;

            VanTablePost vanTablePost = new VanTablePost();
            if (this.vanTablePost != null){
                substance = this.vanTablePost.getSubstance();
                typeList = this.vanTablePost.getTypeList();
                year = this.vanTablePost.getYear();
                month = this.vanTablePost.getMonth();
                dateFrom = this.vanTablePost.getDateFrom();
                dateTo = this.vanTablePost.getDateTo();
                maxRowInPage = this.vanTablePost.getMaxRowInPage();

                editListSubstance(substanceList, substance);
                months.remove(Month.of(Integer.parseInt(month)));
                months.add(0, Month.of(Integer.parseInt(month)));
            }
            arrForTypeQuery = new String[]{substance, typeList, year, month, dateFrom, dateTo};
            vanTablePost.setAll(arrForTypeQuery, maxRowInPage);
            this.vanTablePost = vanTablePost;

            List<Van> vanList = vanService.getVanList(vanTablePost, page, maxRowInPage);
            int vanCount = vanService.vanCount(vanTablePost);
            int pagesCount = (vanCount + (maxRowInPage -1))/ maxRowInPage;
            modelAndView.addObject("page", page);
            modelAndView.addObject("maxRowInPage", maxRowInPage );
            modelAndView.addObject("pagesCount", pagesCount);
            modelAndView.addObject("vanList", vanList);
            modelAndView.addObject("substanceList", substanceList);
            modelAndView.addObject("vanTablePost", this.vanTablePost);
            modelAndView.addObject("months", months);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = "/vanTablePost", method = RequestMethod.POST)
    public ModelAndView vanTable(@ModelAttribute("vanTablePostBuff") VanTablePost vanTablePost) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/vanTable?page=" + this.pageVanTable);
        try {
            this.vanTablePost = vanTablePost;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return modelAndView;
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editVanPage(@PathVariable("id") int id) {
        Van van = vanService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editOrAddVanPage");
        try {
            modelAndView.addObject("van", van);

            modelAndView.addObject("page", pageVanTable);

            List<Substance> substanceList = editListSubstance(substanceService.substanceList(), van);
            modelAndView.addObject("substanceList", substanceList);

            List<String> typeList = ConstTypeAndOverflow.editListType(new ConstTypeAndOverflow().getTypeList(), van);
            modelAndView.addObject("typeList", typeList);

            List<Short> overflowList = ConstTypeAndOverflow.editListOverflow(new ConstTypeAndOverflow().getOverflowList(), van);
            modelAndView.addObject("overflowList", overflowList);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addVanPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editOrAddVanPage");
        try {
            modelAndView.addObject("page", pageVanTable);

            List<Substance> substanceList = substanceService.substanceList();
            modelAndView.addObject("substanceList", substanceList);

            List<String> typeList = new ConstTypeAndOverflow().getTypeList();
            modelAndView.addObject("typeList", typeList);

            List<Short> overflowList = new ConstTypeAndOverflow().getOverflowList();
            modelAndView.addObject("overflowList", overflowList);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editVan(@ModelAttribute("van") Van van) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/vanTable?page=" + this.pageVanTable);
        vanService.edit(van);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addVan(@ModelAttribute("van") Van van) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/vanTable?page=" + this.pageVanTable);
        vanService.add(van);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteVan(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/vanTable?page=" + this.pageVanTable);
        try {
            Van van = vanService.getById(id);
            vanService.delete(van);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return modelAndView;
    }



    @RequestMapping(value = "/substanceCRUD", method = RequestMethod.GET)
    public ModelAndView substanceCRUDPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("substancePage");
        try {
            modelAndView.addObject("page", pageVanTable);
            List<Substance> substanceList = substanceService.substanceList();
            modelAndView.addObject("substanceList", substanceList);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return modelAndView;
    }


    @RequestMapping(value = "/substancePost", method = RequestMethod.POST)
    public ModelAndView substancePost(@ModelAttribute("substanceList") SubstancePost substancePost) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/substanceCRUD");
        try {
            int typeAction = substancePost.getTypeAction();
            String stringInputSubstance = substancePost.getInputSubstance();
            int idSelectSubstance = substancePost.getSelectSubstance();
            Substance substanceBuffer;
            if (typeAction == 0 ) substanceBuffer = new Substance();
            else substanceBuffer = substanceService.getById(idSelectSubstance);
            substanceBuffer.setSubstance(stringInputSubstance);

            switch (typeAction) {
                case 0 -> substanceService.add(substanceBuffer);
                case 1 -> substanceService.edit(substanceBuffer);
                case 2 -> substanceService.delete(substanceBuffer);
            }

        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return modelAndView;
    }



    @RequestMapping(value = "/calculation", method = RequestMethod.GET)
    public ModelAndView calculationOverflowPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("calculationPage");
        try {
            List<String> typeList = new ConstTypeAndOverflow().getTypeList();
            modelAndView.addObject("typeList", typeList);
            CalculationPost calculationPost = new CalculationPost();
            calculationPost.setDensity((short) 0);
            calculationPost.setTyperw(String.valueOf(14));
            calculationPost.setWeight(0);
            TOV tov = new TOV();

            if (this.calculationPost != null){
                calculationPost = this.calculationPost;
            }
            try {
                tov = tovService.getTOV(calculationPost);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
            float maxVolume = tovService.getMaxVolume(calculationPost);

            modelAndView.addObject("calculationPost", calculationPost);
            modelAndView.addObject("tov", tov);
            modelAndView.addObject("maxVolume", maxVolume);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return modelAndView;
    }

    @RequestMapping(value = "/calculationPost", method = RequestMethod.POST)
    public ModelAndView calculationOverflow(@ModelAttribute("calculationPost") CalculationPost calculationPost) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/calculation");
        try {
            this.calculationPost = calculationPost;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return modelAndView;
    }

}
