package demo;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.xpath.*;

public class DriverClass {

	public static void main(String[] args) {
		display();
	}

	static void display() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document d = db.parse("Data.xml");
			XPath xPath = XPathFactory.newInstance().newXPath();

			NodeList nl = (NodeList) xPath.compile("//Doctor").evaluate(d, XPathConstants.NODESET);
			System.out.println("List of Doctors Information: ");
			System.out.println("--------------------------------------------------------------------------------------");
			for (int i = 0; i < nl.getLength(); i++) {
				System.out.println("Doctor Id's: " + xPath.compile(".//@D_Id").evaluate(nl.item(i)));
				System.out.println("Doctor Name: " + xPath.compile(".//Doctor_Name").evaluate(nl.item(i)));
				System.out.println("Doctor Address: " + xPath.compile(".//DoctorAddress").evaluate(nl.item(i)));
				System.out.println("Doctor Phone: " + xPath.compile(".//DoctorPhone").evaluate(nl.item(i)));
				System.out.println("Doctor DOB: " + xPath.compile(".//DOB").evaluate(nl.item(i)));
				System.out.println("Doctor Specialization: " + xPath.compile(".//Specialization").evaluate(nl.item(i)));
				System.out.println("Doctor Appointments: " + xPath.compile(".//AppointmentsInADay").evaluate(nl.item(i)));
				System.out.println("======================================================================================");
			}
			System.out.println("****************************");
			NodeList nl1 = (NodeList) xPath.compile("//Patient").evaluate(d, XPathConstants.NODESET);
			System.out.println("List of Patients Information: ");
			System.out.println("--------------------------------------------------------------------------------------");
			for (int i = 0; i < nl1.getLength(); i++) {
				System.out.println("Patient Id's: " + xPath.compile(".//@P_Id").evaluate(nl1.item(i)));
				System.out.println("Patient Name: " + xPath.compile(".//Patient_Name").evaluate(nl.item(i)));
				System.out.println("Patient Address: " + xPath.compile(".//PatientAddress").evaluate(nl1.item(i)));
				System.out.println("Patient Phone: " + xPath.compile(".//PatientPhone").evaluate(nl1.item(i)));
				System.out.println("Patient DOB: " + xPath.compile(".//DOB").evaluate(nl1.item(i)));
				System.out.println("Appointed Doctor: " + xPath.compile(".//AttendedDoctor/@AttendedBy").evaluate(nl1.item(i)));
				System.out.println("Illness: " + xPath.compile(".//Illness").evaluate(nl1.item(i)));
				System.out.println("======================================================================================");
			}
			System.out.println("********************");
			NodeList nl2 = (NodeList) xPath.compile("//Appointment").evaluate(d, XPathConstants.NODESET);
			System.out.println("List of Appointments: ");
			System.out.println("--------------------------------------------------------------------------------------");
			for (int i = 0; i < nl2.getLength(); i++) {
				System.out.println("Appointment Id: " + xPath.compile(".//@AppointmentId").evaluate(nl2.item(i)));
				System.out.println("Appointed Doctor: " + xPath.compile(".//@AppointedDoctorId").evaluate(nl2.item(i)));
				System.out.println("Appointed Patient: " + xPath.compile(".//@AppointedPatientId").evaluate(nl2.item(i)));
				System.out.println("Appointment Date: " + xPath.compile(".//@AppointmentDate").evaluate(nl2.item(i)));
				System.out.println("Appointment Time: " + xPath.compile(".//@AppointmentTime").evaluate(nl2.item(i)));
				System.out.println("Patient Condition: " + xPath.compile(".//PatientCondition").evaluate(nl2.item(i)));
				System.out.println("======================================================================================");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
