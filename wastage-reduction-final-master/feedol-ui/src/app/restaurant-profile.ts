export class RestaurantProfile{

    username:string;
    email:string;
    role:string;
    name:string;
    mobile:string;
    address:string;
    location:string;
    certificateNo:string;
    certificateName:string

    constructor(username, email, role, name, mobile, address, location, certificateNo,certificateName){
        this.username = username;
        this.email = email;
        this.role = role;
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.location = location;
        this.certificateNo = certificateNo;
        this.certificateName = certificateName;
    }
}