package com.boraji.tutorial.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.boraji.tutorial.springboot.Entity.Job;
import com.boraji.tutorial.springboot.Entity.LaborEntry;
import com.boraji.tutorial.springboot.Entity.Machine;
import com.boraji.tutorial.springboot.Entity.MachineEntry;
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

	private static final String COMMAND = "command";

	private static final String ID = "id";

	private static final String REDIRECT_TO_ADD_TIMESHEET = "redirect:/addTimesheet";

	private static final String MESSAGE = "message";

	private static final String JOB = "job";

	private static final String ALL_JOBS = "allJobs";

	private static final String MACHINE = "machine";

	private static final String ALL_MACHINES = "allMachines";

	private double totalNuberOfHours;

	private double totalAmount;

	private List<LaborEntry> listOfLaborEntries = new ArrayList();

	private List<MachineEntry> listOfMachineEntries = new ArrayList();

	private Timesheet commandTimesheet = new Timesheet();

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute(MESSAGE, "");
		model.addAttribute(COMMAND, new User());
		return "loginPage";
	}

	@RequestMapping(value = "/deleteJob", method = RequestMethod.GET)
	public ModelAndView deleteJob(@ModelAttribute(COMMAND) Job job, BindingResult result) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(JOB, new Job());
		jobService.delete(job);
		model.put(ALL_JOBS, jobService.getAll());
		return new ModelAndView("JobCodeManagement", model);
	}

	@RequestMapping(value = "/saveJob", method = RequestMethod.POST)
	public ModelAndView saveJob(@ModelAttribute(COMMAND) Job job, Model model) {
		jobService.save(job);
		return new ModelAndView("redirect:/addJobPage.html");
	}

	@RequestMapping(value = "/addJobPage", method = RequestMethod.GET)
	public String addJobPage(@ModelAttribute(COMMAND) Job job, Model model) {
		model.addAttribute(JOB, job);
		return "addJob";
	}

	@RequestMapping("/JobCodeManagement")
	public String jobCodeManagment(Model model) {
		model.addAttribute(ALL_JOBS, jobService.getAll());
		model.addAttribute(COMMAND, new Job());
		return "JobCodeManagement";
	}

	@RequestMapping("/addJob")
	public String addJob(Model model) {
		model.addAttribute(JOB, new Job());
		model.addAttribute(COMMAND, new Job());
		return "addJob";
	}

	@RequestMapping("/updateJob")
	public String updateJob(@ModelAttribute(ID) int id, Model model) {
		model.addAttribute(JOB, jobService.findById(id));
		model.addAttribute(COMMAND, new Job());
		model.addAttribute(ALL_JOBS, jobService.getAll());
		return "updateJob";
	}

	@RequestMapping(value = "/updateJobMethod", method = RequestMethod.POST)
	public String updateJobMethod(@ModelAttribute(COMMAND) Job job, Model model) {
		jobService.save(job);
		model.addAttribute("allProducts", jobService.getAll());
		return "updateJob";
	}

	@RequestMapping(value = "/deleteMachine", method = RequestMethod.GET)
	public ModelAndView deleteMachine(@ModelAttribute(COMMAND) Machine machine) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put(MACHINE, new Machine());
		machineService.delete(machine);
		model.put(ALL_MACHINES, machineService.getAll());
		return new ModelAndView("MachineCodeManagement", model);
	}

	@RequestMapping(value = "/saveMachine", method = RequestMethod.POST)
	public ModelAndView saveMachine(@ModelAttribute(COMMAND) Machine machine, Model model) {
		machineService.save(machine);
		return new ModelAndView("redirect:/addMachinePage.html");
	}

	@RequestMapping(value = "/addMachinePage", method = RequestMethod.GET)
	public String addMachinePage(@ModelAttribute(COMMAND) Machine machine, Model model) {
		model.addAttribute(MACHINE, machine);
		return "addMachine";
	}

	@RequestMapping("/MachineManagement")
	public String machineCodeManagment(Model model) {
		model.addAttribute(ALL_MACHINES, machineService.getAll());
		model.addAttribute(COMMAND, new Machine());
		return "MachineManagement";
	}

	@RequestMapping("/addMachine")
	public String addMachine(Model model) {
		model.addAttribute(MACHINE, new Machine());
		model.addAttribute(COMMAND, new Machine());
		return "addMachine";
	}

	@RequestMapping("/updateMachine")
	public String updateMachine(@ModelAttribute(ID) int id, Model model) {
		model.addAttribute(MACHINE, machineService.findById(id));
		model.addAttribute(COMMAND, new Machine());
		model.addAttribute(ALL_MACHINES, machineService.getAll());
		return "updateMachine";
	}

	@RequestMapping(value = "/updateMachineMethod", method = RequestMethod.POST)
	public String updateMachineMethod(@ModelAttribute(COMMAND) Machine machine, Model model) {
		machineService.save(machine);
		model.addAttribute(ALL_MACHINES, machineService.getAll());
		return "updateMachine";
	}

	@RequestMapping("/timesheetApproval")
	public String timesheetApproval(Model model) {
		model.addAttribute("allTimesheets", timesheetService.getAll());
		return "timesheetApproval";
	}

	@RequestMapping("/timesheetReview")
	public String timesheetReview(@ModelAttribute(ID) int id, Model model) {
		model.addAttribute("timesheet", timesheetService.findById(id));
		return "timesheetReview";
	}

	@RequestMapping("/approveTimesheet")
	public String approveTimesheet(@ModelAttribute(ID) int id, Model model) {
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
	public String register(@ModelAttribute(COMMAND) User userFromLoginPage, Model model) {
		User userFromDatabase = userService.getByName(userFromLoginPage.getName());
		if (userFromDatabase != null && userFromDatabase.getPass().equals(userFromLoginPage.getPass())) {
			if (userFromDatabase.getUsr_role().equals("ADMIN")) {
				return "redirect:/adminIndex";
			} else {
				return "redirect:/timecardSubmission";
			}
		} else {
			model.addAttribute(MESSAGE, "User name or password is entered incorrectly");
			return "loginPage";
		}
	}

	@RequestMapping("/adminIndex")
	public String adminIndex(Model model) {
		return "adminIndex";
	}

	@RequestMapping("/addTimesheet")
	public String addTimesheet(Model model) {
		model.addAttribute("commandLaborEntry", new LaborEntry());
		model.addAttribute("commandMachineEntry", new MachineEntry());
		model.addAttribute("totalNuberOfHours", totalNuberOfHours);
		model.addAttribute("totalAmount", totalAmount);
		model.addAttribute("listOfLaborEntries", listOfLaborEntries);
		model.addAttribute("listOfMachineEntries", listOfMachineEntries);
		model.addAttribute("commandTimesheet", commandTimesheet);
		model.addAttribute("allCodesForJobs",
				jobService.getAll().stream().map(j -> j.getJob_code()).collect(Collectors.toList()));
		model.addAttribute("allCodesForMachines",
				machineService.getAll().stream().map(m -> m.getMach_code()).collect(Collectors.toList()));
		return "addTimesheet";
	}

	@RequestMapping("/addLaborEntry")
	public String addLaborEntry(@ModelAttribute(COMMAND) LaborEntry laborEntry, Model model) {
		addHoursAndPriceToTotalFromLaborEntry(laborEntry);
		return REDIRECT_TO_ADD_TIMESHEET;
	}

	@RequestMapping("/addMachineEntry")
	public String addMachineEntry(@ModelAttribute(COMMAND) MachineEntry machineEntry, Model model) {
		addHoursAndPriceToTotalFromLaborMachine(machineEntry);
		return REDIRECT_TO_ADD_TIMESHEET;
	}

	@RequestMapping("/submitTimesheet")
	public String submitTimesheet(@ModelAttribute(COMMAND) Timesheet timesheet, Model model) {
		commandTimesheet = timesheet;
		return REDIRECT_TO_ADD_TIMESHEET;
	}

	@RequestMapping("/submitHiddenForm")
	public String submitHiddenForm(@ModelAttribute(COMMAND) Timesheet timesheet, Model model) {
		timesheetService.save(timesheet);
		return REDIRECT_TO_ADD_TIMESHEET;
	}

	@RequestMapping(value = "/deleteLaborEntry", method = RequestMethod.GET)
	public String deleteLaborEntry(@ModelAttribute("code") String code, BindingResult result) {
		Iterator<LaborEntry> i = listOfLaborEntries.iterator();
		while (i.hasNext()) {
			LaborEntry laborEntry = i.next();
			if (laborEntry.getCode().equals(code)) {
				totalNuberOfHours -= laborEntry.getHoursWorked();
				totalAmount -= getCostOfLaborEntry(laborEntry);
				i.remove();
			}
		}
		return REDIRECT_TO_ADD_TIMESHEET;
	}

	@RequestMapping(value = "/deleteMachineEntry", method = RequestMethod.GET)
	public String deleteMachineEntry(@ModelAttribute("code") String code, BindingResult result) {
		Iterator<MachineEntry> i = listOfMachineEntries.iterator();
		while (i.hasNext()) {
			MachineEntry machineEntry = i.next();
			if (machineEntry.getCode().equals(code)) {
				i.remove();
				totalAmount -= getCostOfMachineEntry(machineEntry);
			}
		}
		return REDIRECT_TO_ADD_TIMESHEET;
	}

	@RequestMapping("/viewOpenTimesheet")
	public String viewOpenTimesheet(@ModelAttribute(ID) int id, Model model) {
		model.addAttribute("timesheet", timesheetService.findById(id));
		return "viewOpenTimesheet";
	}

	@RequestMapping("/deleteSubmitedTimesheet")
	public String deleteSubmitedTimesheet(@ModelAttribute(ID) int id, Model model) {
		timesheetService.delete(timesheetService.findById(id));
		return "timesheetDeleted";
	}

	@RequestMapping("/timecardSuccessfulSubmition")
	public String timecardSuccessfulSubmition(Model model) {
		totalNuberOfHours = 0;
		totalAmount = 0;
		listOfLaborEntries.clear();
		listOfMachineEntries.clear();
		commandTimesheet = new Timesheet();
		return "timecardSuccessfulSubmition";
	}

	private void addHoursAndPriceToTotalFromLaborEntry(LaborEntry laborEntry) {
		totalNuberOfHours += laborEntry.getHoursWorked();
		double costOfTheLaborEntry = getCostOfLaborEntry(laborEntry);
		totalAmount += costOfTheLaborEntry;
		laborEntry.setTotalAmount(costOfTheLaborEntry);
		listOfLaborEntries.add(laborEntry);
	}

	private void addHoursAndPriceToTotalFromLaborMachine(MachineEntry machineEntry) {
		double costOfMachineEntry = getCostOfMachineEntry(machineEntry);
		totalAmount += costOfMachineEntry;
		machineEntry.setTotalAmount(costOfMachineEntry);
		listOfMachineEntries.add(machineEntry);
	}

	private double getCostOfLaborEntry(LaborEntry laborEntry) {
		double hoursWorked = laborEntry.getHoursWorked();
		totalNuberOfHours += hoursWorked;
		Job job = jobService.getAll().stream().filter(j -> j.getJob_code().equals(laborEntry.getCode())).findAny()
				.get();
		return job.getHourly_rate() * hoursWorked;

	}

	private double getCostOfMachineEntry(MachineEntry machineEntry) {
		Machine machine = machineService.getAll().stream().filter(m -> m.getMach_code().equals(machineEntry.getCode()))
				.findAny().get();
		return machine.getHourly_rent() * machineEntry.getHoursUsed();
	}

}
