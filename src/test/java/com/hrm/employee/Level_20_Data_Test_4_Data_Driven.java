package com.hrm.employee;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.data.hrm.EmployeeData;

import commons.BaseTest;
import commons.GlobalConstants;
import pageObjects.hrm.AddEmployeePO;
import pageObjects.hrm.DashboardPO;
import pageObjects.hrm.EmployeeListPO;
import pageObjects.hrm.LoginPO;
import pageObjects.hrm.MyInfoPO;
import pageObjects.hrm.PageGenerator;

public class Level_20_Data_Test_4_Data_Driven extends BaseTest {
	String adminUserName, adminPassword, empFirstName, empLastName, empUserName, empPassWord, employeeID, statusValue;
	String empFullName, editEmpFirstName, editEmpLastName, editEmpGender, editEmpMaritalStatus, editEmpNationality;
	String avatarFilePath =  GlobalConstants.UPLOAD_FOLDER_PATH + "Anh1.jpg";
	
	@Parameters({"browser", "url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		log.info("Pre-Condition: Step 01: Open browser'" + browserName + "' and navigate to '" + appUrl + "'");
		driver = getBrowserDriver(browserName, appUrl);
		loginPage = PageGenerator.getLoginPage(driver);
		
		employeeData = EmployeeData.getEmployee();
		
		statusValue = "Enabled";
		adminUserName = "Admin";
		adminPassword = "admin123";
		
		editEmpMaritalStatus = "Single";
		editEmpNationality = "Vietnamese";
		
		log.info("Pre-Condition - Step 02: Login with Admin role");
		dashboardPage = loginPage.loginToSystem(driver, adminUserName, adminPassword);
	}
	
	@Test
	public void Employee_01_Add_New_Employee() {
		log.info("Add_New_01 - Step 01: Open 'Employee List' page");
		dashboardPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);
		
		log.info("Add_New_01 - Step 02: Click to 'Add' button");
		employeeListPage.clickToButtonByID(driver, "btnAdd");
		addEmployeePage = PageGenerator.getAddEmployeePage(driver);
		
		log.info("Add_New_01 - Step 03: Enter valid info to 'First Name' textbox");
		addEmployeePage.enterTextboxByID(driver, "firstName", employeeData.getFirstname());
		
		log.info("Add_New_01 - Step 04: Enter valid info to 'Last Name' textbox");
		addEmployeePage.enterTextboxByID(driver, "lastName", employeeData.getLastname());
		
		log.info("Add_New_01 - Step 05: Get value of 'Employee ID'");
		employeeID = addEmployeePage.getTextboxValueByID(driver, "employeeId");
		
		log.info("Add_New_01 - Step 06: Click to 'Create Login Details' checkbox");
		addEmployeePage.clickToCheckboxByLabel(driver, "Create Login Details");
		
		log.info("Add_New_01 - Step 07: Enter valid info to 'User Name' textbox");
		addEmployeePage.enterTextboxByID(driver, "user_name", employeeData.getFirstname());;
		
		log.info("Add_New_01 - Step 08: Enter valid info to 'Password' textbox");
		addEmployeePage.enterTextboxByID(driver, "user_password", employeeData.getPassword());;
		
		log.info("Add_New_01 - Step 09: Enter valid info to 'Confirm Password' textbox");
		addEmployeePage.enterTextboxByID(driver, "re_password", employeeData.getPassword());;
		
		log.info("Add_New_01 - Step 10: Select '" + statusValue + "' value in 'Status' dropdown");
		addEmployeePage.selectItemInDropdownByID(driver, "status", statusValue);
		
		log.info("Add_New_01 - Step 11: Click to 'Save' button");
		addEmployeePage.clickToButtonByID(driver, "btnSave");
		myInfoPage = PageGenerator.getMyInfoPage(driver);
		
		log.info("Add_New_01 - Step 12: Open 'Employee List' page");
		myInfoPage.openSubMenuPage(driver, "PIM", "Employee List");
		employeeListPage = PageGenerator.getEmployeeListPage(driver);
		
		log.info("Add_New_01 - Step 13: Enter valid info to 'Employee Name' textbox");
		employeeListPage.sleepInSecond(5);
		employeeListPage.enterTextboxByID(driver, "empsearch_employee_name_empName", employeeData.getFullname());
		employeeListPage.sleepInSecond(5);
		
		log.info("Add_New_01 - Step 14: Click to 'Search' button");
		employeeListPage.clickToButtonByID(driver, "searchBtn");
		employeeListPage.sleepInSecond(5);
		
		log.info("Add_New_01 - Step 15: Verify Employee Infomation displayed at 'Result Table'");
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Id", "1"), employeeID);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "First (&Middle) Name", "1"), empFirstName);
		verifyEquals(employeeListPage.getValueInTableIDAtColumnNameAndRowIndex(driver, "resultTable", "Last Name", "1"), empLastName);
	
	}
	
	@Test
	public void Employee_02_Add_Upload_Avatar() {
		log.info("Upload_Avatar_02 - Step 01: Login with Employee role");
		loginPage = employeeListPage.logoutToSystem(driver);
		dashboardPage = loginPage.loginToSystem(driver, empUserName, empPassWord);
		
		log.info("Upload_Avatar_02 - Step 02: Open Personal Detail Page");
		dashboardPage.openMenuPage(driver, "My Info");
		myInfoPage = PageGenerator.getMyInfoPage(driver);
		
		log.info("Upload_Avatar_02 - Step 03: Click to Change Photo image");
		myInfoPage.clickToChangePhotoImage();
		
		log.info("Upload_Avatar_02 - Step 04: Upload new Avatar image");
		myInfoPage.uploadImage(driver, avatarFilePath);
		
		log.info("Upload_Avatar_02 - Step 05: Click to Upload button");
		myInfoPage.clickToButtonByID(driver, "btnSave");
		
		log.info("Upload_Avatar_02 - Step 06: Verify Success message displayed");
		verifyTrue(myInfoPage.isUpSuccessMessageDisplayed(driver, "Successfully Uploaded"));
		
		log.info("Upload_Avatar_02 - Step 07: Verify new Avatar image is displayed");
		verifyTrue(myInfoPage.isNewAvatarImageDisplayed());
	}
	
	@Test
	public void Employee_03_Personal_Details() {
		log.info("Personal_Details_03 - Step 01: Open 'Personal Details' tab at Side bar");
		myInfoPage.openTabAtSideBarByName("Personal Details");
		
		log.info("Personal_Details_03 - Step 02: Verify all fields at 'Personal Details' tab are disabled");
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_txtEmpFirstName"));
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_txtEmpLastName"));
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_txtEmployeeId"));
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_txtLicenNo"));
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_txtNICNo"));
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_txtSINNo"));
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_optGender_1"));
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_optGender_2"));
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_cmbMarital"));
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_cmbNation"));
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_DOB"));
		
		log.info("Personal_Details_03 - Step 03: Click to 'Edit' button at 'Personal Details' form");
		myInfoPage.clickToButtonByID(driver, "btnSave");
		
		log.info("Personal_Details_03 - Step 04: Verify 'Employee ID' textbox is disabled");
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_txtEmployeeId"));
		
		log.info("Personal_Details_03 - Step 05: Verfy 'Driver's License Number' textbox is disabled");
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_txtLicenNo"));
		
		log.info("Personal_Details_03 - Step 06: Verfy 'SSN Number' textbox is disabled");
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_txtNICNo"));
		
		log.info("Personal_Details_03 - Step 07: Verfy 'SIN Number' textbox is disabled");
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_txtSINNo"));
		
		log.info("Personal_Details_03 - Step 08: Verfy 'Date of Birth' textbox is disabled");
		verifyFalse(myInfoPage.isFieldsEnabledByName(driver, "personal_DOB"));
		
		log.info("Personal_Details_03 - Step 09: Enter new value to 'First Name' textbox");
		myInfoPage.enterTextboxByID(driver, "personal_txtEmpFirstName", editEmpFirstName);
		
		log.info("Personal_Details_03 - Step 10: Enter new value to 'Last Name' textbox");
		myInfoPage.enterTextboxByID(driver, "personal_txtEmpLastName", editEmpLastName);
		
		log.info("Personal_Details_03 - Step 11: Select new value to 'Gender' radio button");
		myInfoPage.clickToRadioByLabel(driver, editEmpGender);
		
		log.info("Personal_Details_03 - Step 12: Select new value to 'Marital Status' dropdown");
		myInfoPage.selectItemInDropdownByID(driver, "personal_cmbMarital", editEmpMaritalStatus);
		
		log.info("Personal_Details_03 - Step 13: Select new value to 'Nationality' dropdown");
		myInfoPage.selectItemInDropdownByID(driver, "personal_cmbNation", editEmpNationality);
		
		log.info("Personal_Details_03 - Step 14: Click to 'Save' button at 'Personal Details' form");
		myInfoPage.clickToButtonByID(driver, "btnSave");
		
		log.info("Personal_Details_03 - Step 15: Verify Success message is displayed");
		verifyTrue(myInfoPage.isUpSuccessMessageDisplayed(driver, "Successfully Saved"));
		
		log.info("Personal_Details_03 - Step 16: Verify 'First Name' textbox is updated success");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmpFirstName"), editEmpFirstName);
		
		log.info("Personal_Details_03 - Step 17: Verify 'Last Name' textbox is updated success");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmpLastName"), editEmpLastName);
		
		log.info("Personal_Details_03 - Step 18: Verify 'Gender' radio button is updated success");
		verifyTrue(myInfoPage.isRadioButtonSelectedByLabel(driver, editEmpGender));
		
		log.info("Personal_Details_03 - Step 19: Verify 'Marital Status' dropdown is updated success");
		verifyEquals(myInfoPage.getSelectedValueInDropdownByID(driver, "personal_cmbMarital"), editEmpMaritalStatus);
		
		log.info("Personal_Details_03 - Step 20: Verify 'Nationality' dropdown is updated success");
		verifyEquals(myInfoPage.getSelectedValueInDropdownByID(driver, "personal_cmbNation"), editEmpNationality);
		
		log.info("Personal_Details_03 - Step 21: Verify 'Employee Id' textbox value is correct");
		verifyEquals(myInfoPage.getTextboxValueByID(driver, "personal_txtEmployeeId"), employeeID);
		
	}
	
	@Test
	public void Employee_04_Contact_Details() {
		
	}
	
	@Test
	public void Employee_05_Emergency_Details() {
		
	}
	
	@Test
	public void Employee_06_Assigned_Dependents() {
		
	}

	@Test
	public void Employee_07_Edit_View_Job() {
		
	}
	
	@Test
	public void Employee_08_Edit_View_Salary() {
		
	}
	
	@Test
	public void Employee_09_Edit_View_Tax() {
		
	}
	
	@Test
	public void Employee_10_Qualifications() {
		
	}
	
	@Test
	public void Employee_11_Search_Employee() {
		
	}
	
	@Parameters({"browser"})
	@AfterClass(alwaysRun = true)
	public void cleanBrowser(String browserName) {
		log.info("Post-Condition: Close browser '" + browserName + "'");
		cleanBrowserAndDriver();
	}
	
	LoginPO loginPage;
	AddEmployeePO addEmployeePage;
	DashboardPO dashboardPage;
	EmployeeListPO employeeListPage;
	MyInfoPO myInfoPage;
	EmployeeData employeeData;
}
