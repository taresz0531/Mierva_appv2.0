package hu.tarnai.minerva.enums;

public enum Order {
	ASCENDENT(1), 
	DESCENDANT(-1);

	
	private int order;

	private Order(int order) {
		this.order = order;
	}
	
	public int getOrder() {
		return order;
	}
	
}
