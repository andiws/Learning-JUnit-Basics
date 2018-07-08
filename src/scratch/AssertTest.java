package scratch;

import org.junit.Test; 
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.io.*; 
import java.util.*;



public class AssertTest {
	private Account account; 
	
	@Before
	public void createAccount() {
		account =
				new Account ("an account name");
	}
	
	@Test
	public void hasPositiveBalance() {
		account.deposit(50);
		assertTrue(account.hasPositiveBalance()); 
		
	}
	@Test
	public void depositIncreasesBalance() {
		int initialBalance = account.getBlance(); 
		account.deposit(100);
		assertTrue(account.getBalance() > initialBalance);
		assertThat(account.getBalance(), equalTo(100)); 
	}

}
