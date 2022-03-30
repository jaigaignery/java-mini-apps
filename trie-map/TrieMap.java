//Note: All of your TrieMapInterface method implementations must function recursively
//I have left the method signatures from my own solution, which may be useful hints in how to approach the problem
//You are free to change/remove/etc. any of the methods, as long as your class still supports the TrieMapInterface
import java.util.ArrayList;

public class TrieMap implements TrieMapInterface{
  TrieMapNode root;
  
  public TrieMap(){
    root = new TrieMapNode();
  }

  public void put(String key, String value){
    put(root, key, value);
  }

  public void put(TrieMapNode current, String curKey, String value){
    if (!curKey.equals("")){
      if (!current.getChildren().containsKey(curKey.charAt(0))) {
        current.getChildren().put(curKey.charAt(0), new TrieMapNode());
      }
      current = current.getChildren().get(curKey.charAt(0));
      curKey = curKey.substring(1);
      put(current, curKey, value);
    }else{
      current.setValue(value);
    }
  }

  public String get(String key){
    return get(root, key);
  }

  public String get(TrieMapNode current, String curKey) {

    if (!curKey.equals("")&&!current.getChildren().containsKey(curKey.charAt(0))){
      return "";
    }

    if (curKey.equals("")&&current.getValue()==null){
      return "";
    }

    if (curKey.equals("") && current.getValue()!=null){
      return current.getValue();
    }

    current = current.getChildren().get(curKey.charAt(0));
    curKey = curKey.substring(1);
    return get(current, curKey);
  }

  public boolean containsKey(String key){
    return containsKey(root, key);
  }

  public boolean containsKey(TrieMapNode current, String curKey) {

    if (!curKey.equals("")&&!current.getChildren().containsKey(curKey.charAt(0))){
      return false;
    }

    if (curKey.equals("")&&current.getValue()==null){
      return false;
    }

    if (curKey.equals("") && current.getValue()!=null){
      return true;
    }

    current = current.getChildren().get(curKey.charAt(0));
    curKey = curKey.substring(1);
    return containsKey(current, curKey);
  }

  public ArrayList<String> getKeysForPrefix(String prefix){
    return getKeysForPrefix(root, prefix, new ArrayList<String>());
  }

  public ArrayList<String> getKeysForPrefix(TrieMapNode current, String prefix, ArrayList<String> keys) {
    if (!prefix.equals("") && current.getChildren().containsKey(prefix.charAt(0))) {
      current = current.getChildren().get(prefix.charAt(0));
      prefix = prefix.substring(1);
      getKeysForPrefix(current, prefix, keys);
    }
    if (prefix.equals("")){
      if (current.getValue()!=null && !keys.contains(current.getValue())){
        keys.add(current.getValue());
      }
      for (TrieMapNode child : current.getChildren().values()){
        if (child.getValue()!=null && !keys.contains(child.getValue())){
          keys.add(child.getValue());
        }
        getKeysForPrefix(child, prefix, keys);
      }
    }
    return keys;
  }

  public void print(){
    print(root);
  }




  public void print(TrieMapNode current) {
    for (TrieMapNode child : current.getChildren().values()){
      if (child.getValue()!=null){
        System.out.println(child.getValue());
      }
      print(child);
    }
  }

  public static void main(String[] args){
  }
}