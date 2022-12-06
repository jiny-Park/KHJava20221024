package example.Shopping;

import java.util.List;
import java.util.function.Predicate;

// interface SalesService에 필요한 기능을 선언(정의) -> SalesServiceImp implements SalesService에 구현(실행)
public interface SalesService {

	Sales inputSales(String type);

	void printByYear(List<Sales> salesList);

	void printByMonth(List<Sales> salesList);

	void printByDay(List<Sales> salesList);
	
	void printSales(List<Sales> salesList, Predicate<Sales> p);
}
