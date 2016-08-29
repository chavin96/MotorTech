package controller;

import database.DatabaseManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Customer;

public class CustomerRegistrationController {

	@FXML
	private TextField txtCustomerName;
	@FXML
	private TextField txtCustomerCode;
	@FXML
	private TextField txtAddressLine1;
	@FXML
	private TextField txtAddressLine2;
	@FXML
	private TextField txtTelephone;
	@FXML
	private TextField txtFax;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtContactPerson;
	@FXML
	private TextField txtVehicleNumber;
	@FXML
	private TextField txtVehicleModel;
	@FXML
	private TextField txtVehicleMake;
	@FXML
	private TextField txtEngineNumber;
	@FXML
	private TextField txtChassisNo;
	@FXML
	private TextField txtVehicleColor;

	public void insertCustomerData(ActionEvent event) throws Exception {

		txtCustomerCode.getText();
		txtCustomerName.getText();
		txtAddressLine1.getText();
		txtAddressLine2.getText();
		txtTelephone.getText();
		txtFax.getText();
		txtEmail.getText();
		txtContactPerson.getText();
		txtVehicleNumber.getText();
		txtVehicleModel.getText();
		txtVehicleMake.getText();
		txtEngineNumber.getText();
		txtChassisNo.getText();
		txtVehicleColor.getText();

		Customer customer = new Customer();
		customer.setName(txtCustomerName.getText());
		customer.setCode(txtCustomerCode.getText());
		customer.setAddress((txtAddressLine1.getText()).concat((txtAddressLine2.getText())));
		customer.setTelephone(txtTelephone.getText());
		customer.setFax(txtFax.getText());
		customer.setEmail(txtEmail.getText());
		customer.setContactPerson(txtContactPerson.getText());
		customer.setVehicleNumber(txtVehicleNumber.getText());
		customer.setVehicleModel(txtVehicleModel.getText());
		customer.setVehicleMake(txtVehicleMake.getText());
		customer.setVehicleColour(txtVehicleColor.getText());
		customer.setEngineNumber(txtEngineNumber.getText());
		customer.setChassisNumber(txtChassisNo.getText());

		DatabaseManager.getInstance().insertCustomer(customer);
	}
}
