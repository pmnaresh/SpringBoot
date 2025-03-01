import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.test.repository.Storage;

class StorageTest {

	@org.junit.jupiter.api.Test
	void readAadharRecordtest() {
		fail("Not yet implemented");
		Storage storage= new Storage();
	
		assertEquals(new ArrayList().getClass(),storage.readAadharRecord(null).getClass());
		
	}
	@Test
	public void addNumber(int number) {
		int Total = number+number;
		System.out.println(Total);
		
		
		
	}
	@Test
	public void squareOfNumbers(int num) {
		int square= num*num;
		System.out.println(square);
		
	}

}
