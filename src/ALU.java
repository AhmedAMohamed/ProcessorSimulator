
public class ALU {
    String data1;
    String data2;
    String aluControl;
    String result;
    boolean slt;
    boolean zero;
    
   private String and(String d1,String d2) {
       String r = new String();
       for(int i = 0; i < d1.length(); i++) {
           if(d1.charAt(i) == d2.charAt(i) && (d1.charAt(i) == '1')) {
               r += '1';
           }
           else {
               r += '0';
           }
       }
       return r;
   }
   private String or(String d1,String d2) {
       String r = new String();
       for(int i = 0; i < d1.length(); i++) {
           if(d1.charAt(i) == d2.charAt(i) && (d1.charAt(i) == '0')) {
               r += '0';
           }
           else {
               r += '1';
           }
       }
       return r;
   }
   private String nor(String d1){
       String r= new String();
       for(int i=0; i<d1.length();i++){
           if(d1.charAt(i)=='0'){
               r+='1';
           }
           else r+='0';
       }
       return r;
   }
   private String add(String d1,String d2) {
       String r = new String();
       r = Integer.toBinaryString(Integer.parseInt(d1) + Integer.parseInt(d2));
       return r;
   }
   private String sub(String d1,String d2){
       String r=new String();
       r=Integer.toBinaryString(Integer.parseInt(d1)-Integer.parseInt(d2));
       return r;
   }
   private boolean slt(String d1,String d2){
       if(Integer.parseInt(d1)<Integer.parseInt(d2))
           return true;
       else return false;
   }
   public void setData1 (String data1) {
       this.data1 = data1;
   }
   public void setData2 (String data2) {
       this.data2 = data2;
   }
   public void setAluOp (String op) {
       this.aluControl = op;
   }
   public String getResult() {
       if(aluControl.equalsIgnoreCase("and")) {
           result = and(data1,data2);
       }
       else if(aluControl.equalsIgnoreCase("or")) {
           result = or(data1,data2);
       }
       else if(aluControl.equalsIgnoreCase("add")) {
           result = add(data1,data2);
       }
       else if(aluControl.equalsIgnoreCase("sub")){
           result=sub(data1,data2);
       }
       else if(aluControl.equalsIgnoreCase("slt")){
           slt=slt(data1,data2);
       }
       else if(aluControl.equalsIgnoreCase("nor")){
           result=nor(data1);
       }
       if(Integer.parseInt(result)==0)
    	   zero=true;
       else zero=false;
        return result;
   }
}