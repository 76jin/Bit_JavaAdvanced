package sems.vo;

public class StudentVo extends UserVo {
  private static final long serialVersionUID = 1L;
  
	String company;
	String position;
	int		 workingState; // 재직여부
	String lastSchool;	 // 최종학력
	String bankingAccount;			 // 통장번호
	
	public StudentVo() {}
	
	@Override
  public String toString() {
	  return "StudentVo [company=" + company + ", position=" + position
	      + ", workingState=" + workingState + ", lastSchool=" + lastSchool
	      + ", account=" + bankingAccount + ", no=" + no + ", email=" + email
	      + ", password=" + password + ", name=" + name + ", tel=" + tel
	      + ", fax=" + fax + ", postNo=" + postNo + ", address=" + address
	      + ", photoPath=" + photoPath + "]";
  }
	
	

	public String getCompany() {
		return company;
	}

	public StudentVo setCompany(String company) {
		this.company = company;
		return this;
	}

	public String getPosition() {
		return position;
	}

	public StudentVo setPosition(String position) {
		this.position = position;
		return this;
	}

	public int getWorkingState() {
		return workingState;
	}

	public StudentVo setWorkingState(int workingState) {
		this.workingState = workingState;
		return this;
	}

	public String getLastSchool() {
		return lastSchool;
	}

	public StudentVo setLastSchool(String lastSchool) {
		this.lastSchool = lastSchool;
		return this;
	}

	public String getBankingAccount() {
		return bankingAccount;
	}

	public StudentVo setBankingAccount(String account) {
		this.bankingAccount = account;
		return this;
	}
	
	
	
}
