package bank;

public class Shinhan extends Bank {
	// 잔액 조회 시 재산 반토막
	@Override
	public int getBalance() {
		this.setMoney(this.getMoney() / 2);
		return super.getBalance();
	}
}