package day28Practice;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;


@Data
public class MemberPt implements Serializable {
	
	private static final long serialVersionUID = 3379367193466857078L;
	private String id, pw;
	private Date joinDate;
	private Authority authority;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberPt other = (MemberPt) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pw == null) {
			if (other.pw != null)
				return false;
		} else if (!pw.equals(other.pw))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pw == null) ? 0 : pw.hashCode());
		return result;
	}
	
	public MemberPt(String id, String pw, Date joinDate, Authority authority) {
		this.id = id;
		this.pw = pw;
		this.authority = authority;
		joinDate = new Date();
	}
	
	public MemberPt(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

}


enum Authority {
	ADMIN, MEMBER;
}