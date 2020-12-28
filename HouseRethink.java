
public class HouseRethink {
	private String streetAddress;
	private String city;
	private String state;
	private int zipcode;
	private String modelName;
	private int sqFt;
	private String status;
	
	public HouseRethink() {
		streetAddress = null;
		city = null;
		state = null;
		zipcode = -1;
		modelName = null;
		sqFt = -1;
		status = null;
	}
	public HouseRethink(String houseStreetAddress, String houseCity, String houseState, int houseZipcode, 
			             String houseModelName, int houseSqFt, String houseStatus) {
		streetAddress = houseStreetAddress;
		city = houseCity;
		state = houseState;
		zipcode = houseZipcode;
		modelName = houseModelName;
		sqFt = houseSqFt;
		status = houseStatus;
	}
	public String setStreetAddress (String inputStreetAddress) {
		streetAddress = inputStreetAddress;
		return streetAddress;
	}
	public void setCity (String inputCity) {
		city = inputCity;
	}
	public void setState (String inputState) {
		state = inputState;
	}
	public void setZipcode (String inputZipcode) {
		zipcode = Integer.parseInt(inputZipcode);
	}
	public void setModelName (String inputModelName) {
		modelName = inputModelName;
	}
	public void setSqFt (String inputSqFt) {
		sqFt = Integer.parseInt(inputSqFt);
	}
	public String setStatus (String inputStatus) {
		status = inputStatus;
		return status;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public String getModelName() {
		return modelName;
	}
	public int getSqFt() {
		return sqFt;
	}
	public String getStatus() {
		return status;
	}
	public String print() {
		String concatHome = streetAddress + ", " + city + ", " + state + ", " + zipcode + ", "+ modelName + ", " + sqFt + ", " + status;
		return concatHome;
	}
}
