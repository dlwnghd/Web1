let account = { // 중괄호가 보이면 객체다
    owner: "이주홍",
    code: "1234",
    balance: 15000,
    deposit: function(money){this.balance += money;},
    withdraw: function(money){this.balance -= money;},
    showBalance: function(){return this.balance}
};
let train = new Object();

with(console){
    log(account);
    log(account.owner);
    log(account['owner']);
    log(account['balance']);
    account.deposit = (50000);
    log(account.showBalance());
}