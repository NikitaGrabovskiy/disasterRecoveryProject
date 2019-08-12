package com.boraji.tutorial.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.boraji.tutorial.springboot.Entity.Job;
import com.boraji.tutorial.springboot.Entity.Machine;
import com.boraji.tutorial.springboot.Entity.Timesheet;
import com.boraji.tutorial.springboot.Entity.User;

import com.boraji.tutorial.springboot.service.JobService;
import com.boraji.tutorial.springboot.service.MachineService;
import com.boraji.tutorial.springboot.service.TimesheetService;
import com.boraji.tutorial.springboot.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	JobService jobService;

	@Autowired
	MachineService machineService;

	@Autowired
	TimesheetService timesheetService;

	@RequestMapping("/")
	public String index(Model model) {

		// userService.save(new User("USER","USER","USER"));
//		jobService.save(new Job("ggg","ffff",0.5,99.0));
//		machineService.save(new Machine("ggg","ffff",0.5,99.0));
		/// timesheetService.save(new Timesheet("ggg","ffff",0.5,99.0,false));
		model.addAttribute("message", "");
		model.addAttribute("command", new User());
		return "loginPage";
	}

	@RequestMapping(value = "/deleteJob", method = RequestMethod.GET)
	public ModelAndView deleteJob(@ModelAttribute("command") Job job, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("job", new Job());
		jobService.delete(job);
		model.put("allJobs", jobService.getAll());
		return new ModelAndView("JobCodeManagement", model);
	}

	@RequestMapping(value = "/saveJob", method = RequestMethod.POST)
	public ModelAndView saveJob(@ModelAttribute("command") Job job, BindingResult result, Model model) {
		jobService.save(job);
		return new ModelAndView("redirect:/addJobPage.html");
	}

	@RequestMapping(value = "/addJobPage", method = RequestMethod.GET)
	public String addJobPage(@ModelAttribute("command") Job job, BindingResult result, Model model) {
		model.addAttribute("job", job);
		return "addJob";
	}

	@RequestMapping("/JobCodeManagement")
	public String jobCodeManagment(Model model) {
		model.addAttribute("allJobs", jobService.getAll());
		model.addAttribute("command", new Job());
		return "JobCodeManagement";
	}

	@RequestMapping("/addJob")
	public String addJob(Model model) {
		model.addAttribute("job", new Job());
		model.addAttribute("command", new Job());
		return "addJob";
	}

	@RequestMapping("/updateJob")
	public String updateJob(@ModelAttribute("id") String id, Model model) {
		model.addAttribute("job", jobService.findById(Integer.valueOf(id).intValue()));
		model.addAttribute("command", new Job());
		model.addAttribute("allJobs", jobService.getAll());
		return "updateJob";
	}

	@RequestMapping(value = "/updateJobMethod", method = RequestMethod.POST)
	public String updateJobMethod(@ModelAttribute("command") Job job, BindingResult result, Model model) {
		jobService.save(job);
		model.addAttribute("allProducts", jobService.getAll());
		return "updateJob";
	}

	@RequestMapping(value = "/deleteMachine", method = RequestMethod.GET)
	public ModelAndView deleteMachine(@ModelAttribute("command") Machine machine, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("machine", new Machine());
		machineService.delete(machine);
		model.put("allMachines", machineService.getAll());
		return new ModelAndView("MachineCodeManagement", model);
	}

	@RequestMapping(value = "/saveMachine", method = RequestMethod.POST)
	public ModelAndView saveMachine(@ModelAttribute("command") Machine machine, BindingResult result, Model model) {
		machineService.save(machine);
		return new ModelAndView("redirect:/addMachinePage.html");
	}

	@RequestMapping(value = "/addMachinePage", method = RequestMethod.GET)
	public String addMachinePage(@ModelAttribute("command") Machine machine, BindingResult result, Model model) {
		model.addAttribute("machine", machine);
		return "addMachine";
	}

	@RequestMapping("/MachineManagement")
	public String machineCodeManagment(Model model) {
		model.addAttribute("allMachines", machineService.getAll());
		model.addAttribute("command", new Machine());
		return "MachineManagement";
	}

	@RequestMapping("/addMachine")
	public String addMachine(Model model) {
		model.addAttribute("machine", new Machine());
		model.addAttribute("command", new Machine());
		return "addMachine";
	}

	@RequestMapping("/updateMachine")
	public String updateMachine(@ModelAttribute("id") String id, Model model) {
		model.addAttribute("machine", machineService.findById(Integer.valueOf(id).intValue()));
		model.addAttribute("command", new Machine());
		model.addAttribute("allMachines", machineService.getAll());
		return "updateMachine";
	}

	@RequestMapping(value = "/updateMachineMethod", method = RequestMethod.POST)
	public String updateMachineMethod(@ModelAttribute("command") Machine machine, BindingResult result, Model model) {
		machineService.save(machine);
		model.addAttribute("allMachines", machineService.getAll());
		return "updateMachine";
	}

	@RequestMapping("/timesheetApproval")
	public String timesheetApproval(Model model) {
		model.addAttribute("allTimesheets", timesheetService.getAll());
		return "timesheetApproval";
	}

	@RequestMapping("/timesheetReview")
	public String timesheetReview(@ModelAttribute("id") int id, Model model) {
		model.addAttribute("timesheet", timesheetService.findById(id));
		return "timesheetReview";
	}

	@RequestMapping("/approveTimesheet")
	public String approveTimesheet(@ModelAttribute("id") int id, Model model) {
		Timesheet timesheet = timesheetService.findById(id);
		timesheet.setFinalized(true);
		timesheetService.save(timesheet);
		return "aproveOrDismissTimesheet";
	}

	@RequestMapping("/timecardSubmission")
	public String timecardSubmission(Model model) {
		model.addAttribute("allTimesheets", timesheetService.getAll());
		return "timecardSubmission";
	}

	@RequestMapping("/register")
	public String register(@ModelAttribute("command") User userFromLoginPage, Model model) {

		User userFromDatabase = userService.getByName(userFromLoginPage.getName());

		if (userFromDatabase != null && userFromDatabase.getPass().equals(userFromLoginPage.getPass())) {
			
			if (userFromDatabase.getUsr_role().equals("ADMIN")) {
				return "redirect:/adminIndex";
			} else {
				return "redirect:/userIndex";
			}
			
		} else {
			
			model.addAttribute("message", "User name or password is entered incorrectly");
			return "loginPage";

		}
	}

	@RequestMapping("/adminIndex")
	public String adminIndex(Model model) {
		return "adminIndex";
	}

	@RequestMapping("/userIndex")
	public String userIndex(Model model) {
		return "userIndex";
	}
}
