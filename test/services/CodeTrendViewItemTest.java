package services;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class CodeTrendViewItemTest {

	@Test
	public void itShouldFormatASimpleNumber() {
		CodeTrendItem item1 = new CodeTrendItem("Java", 34.3939393);
		
		assertThat(item1.toString()).isEqualTo("34.39");	
	}
	
	@Test
	public void itShouldRoundUp() {
		CodeTrendItem item1 = new CodeTrendItem("Java", 34.66666);
		
		assertThat(item1.toString()).isEqualTo("34.67");
	}
	
	@Test
	public void itShouldNotRoundDown() {
		CodeTrendItem item1 = new CodeTrendItem("Java", 34.33333);
		
		assertThat(item1.toString()).isEqualTo("34.33");
	}
	
	@Test
	public void itShouldFillDecimalPlaces() {
		CodeTrendItem item1 = new CodeTrendItem("Java", 34D);
		
		assertThat(item1.toString()).isEqualTo("34.00");
	}
	

}
