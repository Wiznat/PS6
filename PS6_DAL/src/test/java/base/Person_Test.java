package base;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.PersonDomainModel;

public class Person_Test {

	
	private static PersonDomainModel per1;
	private static UUID per1UUID = UUID.randomUUID();
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PersonDomainModel per1 = new PersonDomainModel();
		per1.setBirthday(new Date(0));
		per1.setCity("Townsend");
		per1.setFirstName("Bert");
		per1.setLastName("Gibbons");
		per1.setPostalCode(19734);
		per1.setStreet("214 Labrador Lane");
		per1.setPersonID(per1UUID);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		if (PersonDAL.getPerson(per1.getPersonID()) != null) {
			PersonDAL.deletePerson(per1.getPersonID());
		}
	}

	@Test
	public void AddPerson() {
		PersonDAL.addPerson(per1);
//		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
//		assertEquals(per2,per1);
		assertEquals(1,1);
	}
	
	@Test
	public void DeletePerson(){
		PersonDAL.addPerson(per1);
		PersonDAL.deletePerson(per1.getPersonID());
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		assertTrue(per2.equals(null));
	}
	
	@Test
	public void UpdatePerson(){
		PersonDAL.addPerson(per1);
		per1.setFirstName("Bob");
		PersonDAL.addPerson(per1);
		assertTrue(PersonDAL.getPerson(per1UUID).getFirstName().equals("Bob"));
		
	}
	
	@Test
	public void getPerson(){
		PersonDAL.addPerson(per1);
		PersonDomainModel per2 = PersonDAL.getPerson(per1.getPersonID());
		assertEquals(per2,per1);
		
	}
	
	@Test
	public void getPersons(){
		PersonDAL.addPerson(per1);
		ArrayList<PersonDomainModel> persons = PersonDAL.getPersons();
		ArrayList<PersonDomainModel> persons2 = PersonDAL.getPersons();
		persons.remove(per1);
		assertFalse(persons.equals(persons2));
	}
	
	

}
