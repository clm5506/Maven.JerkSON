package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.List;

public class ItemParser {

    public List<Item> parseItemList(String valueToParse) {

       String[] arr = valueToParse.split("##");
       List<Item> itemz = new ArrayList<>();

       for(int i = 0; i < arr.length; i++){
           try {
               itemz.add(parseSingleItem(arr[i]));
           } catch (ItemParseException e) {

           }
       }

    return itemz;
    }

  //  public String[] parse(String string){

//        String[] ans = string.toLowerCase().split(";");
//      //  String[] ans = string.toLowerCase().split("[(@^*%#;)]");
//        StringBuilder sb = new StringBuilder();
//
//        for(int i = 0; i < ans.length; i++){
//            ans[i] = ans[i].toLowerCase().split("[(@^*%#;)]")[1];
//        }
//        for(String str : ans){
//          int i = str.indexOf(":");
//            sb.append(str.substring(i+1,str.length()));
//            sb.append(" ");
//        }
//
//        return sb.toString().split(" ");
  //  }

    public Item parseSingleItem(String singleItem) throws ItemParseException {

        String[] ans = singleItem.toLowerCase().split(";");

        try {
            for (int i = 0; i < ans.length; i++) {
                ans[i] = ans[i].toLowerCase().split("[(@^*:%#)]")[1];
            }
        } catch (ArrayIndexOutOfBoundsException e){
            throw new ItemParseException();
        }

       Item item = new Item(ans[0], Double.valueOf(ans[1]), ans[2], ans[3]);

       return item;
    }


}
