package tourism;

import java.util.Date;

public class Visitor implements java.io.Serializable {

	String id;
	private int visitCount;
	private Date lastVisit;
	private transient long currentVisitToken;

	Visitor(String id) {
		this.id = id;
	}

	public final String getId() { return id; }

	public final int getVisitCount() { return visitCount; }

	public final Date getLastVisit() { return lastVisit; }

	public final long getCurrentVisitToken() { return currentVisitToken; }

	public boolean visit() {
		visitCount += 1;
		lastVisit = new Date();
		currentVisitToken = System.currentTimeMillis() % 1000000;
		return visitCount > 1;
	}

	static final long serialVersionUID = 1L;
}

