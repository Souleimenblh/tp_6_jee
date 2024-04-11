package web;
import java.util.ArrayList;
import java.util.List;
import aeroport.entities.Type;
public class TypeModel {
List<Type> types = new ArrayList<>();
public List<Type> getTypes() {
return types;
}
public void setTypes(List<Type> types) {
this.types = types;
}
}
