package imise;

public class Item {
	public String getName() {
		return name;
	}
	private String name;
	private String eventOID;
	private String crfOID;
	private String groupOID;
	private String itemOID;
	
	private String group;
	private String description;
	private int rowNum;
	
	public String getDescription() {
		return description;
	}
	public boolean update(String itemOID,String groupOID) {
		if (!this.itemOID.equals(itemOID)) System.out.println(itemOID + " " + this.itemOID);
		if (!this.groupOID.equals(groupOID)) System.out.println(groupOID + " " + this.groupOID);
		if (this.itemOID.equals(itemOID) && this.groupOID.equals(groupOID)) return false;   
		this.itemOID = itemOID;
		this.groupOID = groupOID;
		return true;
	}
	public String getGroup() {
		return group;
	}
	public String getOID() {
		return itemOID;
	}
	public String getGroupOID(boolean first) {
		return groupOID + (first?"[1]":"");
	}
	public String getGroupOID() {
		return groupOID;
	}
	public String getFullOID(boolean first) {
		return eventOID+"."+crfOID+"."+getGroupOID(first)+"."+itemOID;
	}
	public Item(String name,
				String eventOID,
				String crfOID,
				String groupOID, 
				String itemOID,
				String group,
				String description, int rowNum) {
		this.name = name;
		this.eventOID = eventOID;
		this.crfOID = crfOID;
		this.groupOID = groupOID;
		this.itemOID = itemOID;
		this.group = group;
		this.description = description;
		this.rowNum = rowNum;
	}
	public int getRowNum() {
		return rowNum;
	}
}
