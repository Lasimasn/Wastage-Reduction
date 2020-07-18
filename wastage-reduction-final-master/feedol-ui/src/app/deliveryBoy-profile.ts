export class DeliveryBoyProfile{
​
    username:string;
    email:string;
    role:string;
    name:string;
    mobile:string;
    address:string;
    licenseNo:string;
    licenseName:string
​
    constructor(username, email, role, name, mobile, address,  licenseNo,licenseName){
        this.username = username;
        this.email = email;
        this.role = role;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.licenseNo = licenseNo;
        this.licenseName = licenseName;
    }
}