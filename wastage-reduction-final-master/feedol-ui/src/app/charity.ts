export class Charity{

    username:string;
    password:string;
    email:string;
    role:string;
    charityName:string;
    mobile:string;
    address:string;
    location:string;
    foodRequirement:string;
    certificateNo:string;
    certificateName:string

    constructor(username, password, email, role, charityName, mobile, address, location, foodRequirement, certificateNo,certificateName){
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.charityName = charityName;
        this.mobile = mobile;
        this.address = address;
        this.location = location;
        this.foodRequirement = foodRequirement;
        this.certificateNo = certificateNo;
        this.certificateName = certificateName;
    }
}