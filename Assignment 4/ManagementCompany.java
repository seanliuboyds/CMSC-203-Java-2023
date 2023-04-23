import javafx.scene.layout.Region;

public class ManagementCompany {
	private int MAX_PROPERTY = 5;
	private double mgmFeePer;
	private String name;
	private String taxID;
	private Property[] properties;
	private int MGMT_WIDTH = 10;
	private int MGMT_DEPTH = 10;
	private Plot plot;
	private int numProperties;
	
	ManagementCompany() {
		
		name = "";
		taxID = "";
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		numProperties = 0;
		properties = new Property[MAX_PROPERTY];
		

	}
	
	ManagementCompany(String name, String taxID, double mgmFee) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;

		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		properties = new Property[MAX_PROPERTY];
		numProperties = 0;
	}
	
	ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		plot = new Plot(x, y, width, depth);
		properties = new Property[MAX_PROPERTY];
		numProperties = 0;
	}
	
	ManagementCompany(ManagementCompany otherCompany) {
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
		this.properties = new Property[MAX_PROPERTY];
		for (int i = 0; i < MAX_PROPERTY; i++) {
			if (otherCompany.properties[i] != null) {
				this.properties[i] = otherCompany.properties[i];
			}
		}
		numProperties = 0;
		this.plot = new Plot(otherCompany.plot);
		
	}
	
	public int getMAX_PROPERTY() {
        return MAX_PROPERTY;
    }
	
	public double totalRent() {
        double total = 0.0;
        for (int i = 0; i < numProperties; i++) {
            total += properties[i].getRentAmount();
        }
        return total;
    }
	
	public double maxRentProp() {
        double max = 0.0;
        for (int i = 0; i < numProperties; i++) {
            if (properties[i].getRentAmount() > max) {
                max = properties[i].getRentAmount();
            }
        }
        return max;
    }
	
	private int maxRentPropertyIndex() {
        int index = -1;
        double max = 0.0;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].getRentAmount() > max) {
                max = properties[i].getRentAmount();
                index = i;
            }
        }
        return index;
    }
	
	private String displayPropertyAtIndex(int i) {
	    if (i < 0 || i >= properties.length) {
	        return "Invalid index";
	    }
	    return properties[i].toString();
	}
	
	public int addProperty(Property property) {
		
		for (int i = 0; i < numProperties; i++) {
	        if (property.getPlot().overlaps(properties[i].getPlot())) {
	            return -4;
	        }
	    }
		
		 if (numProperties >= MAX_PROPERTY) {
		        return -1;
		 }
		
	    if (property == null) {
	        return -2;
	    }

	   

	    if (!this.plot.encompasses(property.getPlot())) {
	        return -3;
	    } else {
	    	properties[numProperties] = property;
		    numProperties++;

		    return numProperties - 1;
	    }

	    

	    
	}
	
	public int addProperty(String name, String city, double rent, String owner) {
	    Property property = new Property(name, city, rent, owner);
	    
	    for (int i = 0; i < numProperties; i++) {
	        if (property.getPlot().overlaps(properties[i].getPlot())) {
	            return -4;
	        }
	    }
		
		 if (numProperties >= MAX_PROPERTY) {
		        return -1;
		 }
		
	    if (property.equals(null)) {
	        return -2;
	    }

	   

	    if (!this.plot.encompasses(property.getPlot())) {
	        return -3;
	    } else {
	    	properties[numProperties] = property;
		    numProperties++;

		    return numProperties - 1;
	    }

	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
	    Property property = new Property(name, city, rent, owner, x, y, width, depth);
	    
	    
	    for (int i = 0; i < numProperties; i++) {
	        if (property.getPlot().overlaps(properties[i].getPlot())) {
	            return -4;
	        }
	    }
		
		 if (numProperties >= MAX_PROPERTY) {
		        return -1;
		 }
		
	    if (property.equals(null)) {
	        return -2;
	    }

	   plot = new Plot(x, y, width, depth);

	    if (!this.plot.encompasses(property.getPlot())) {
	        return -3;
	    } else {
	    	properties[numProperties] = property;
		    numProperties++;

		    return numProperties - 1;
	    }
	}

	public Plot getPlot() {
		// TODO Auto-generated method stub
		return this.plot;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	
	
}
