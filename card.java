//name. value, image
class Cards{
  private String name;
  private int value;
  private String image;

  public Cards(String name, int value, String image) {
    //for better Encapsulation 
    this.setName(name);
    this.setValue(value);
    this.setImage(image);
  }

  //setters
public void setName(String name){
  this.name=name;
}
  public void setValue(int value){
    this.value=value;
  }
  public void setImage(String image){
    this.image=image;
  }
  
  //getters
  public String getName() {
    return name;
  }

  public int getValue() {
    return value;
  }

  public String getImage() {
    return image;
  }

}
