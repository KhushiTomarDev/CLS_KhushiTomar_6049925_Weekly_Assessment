package cg.demo.Assessment1;

import java.util.List;

public interface Order {
	
	public boolean addOrder(abes_order order, int custId);
	public abes_order viewOrderByOrderID(int orderId);
	public List<abes_order> viewOrdersByCustName(String Customer);

}
