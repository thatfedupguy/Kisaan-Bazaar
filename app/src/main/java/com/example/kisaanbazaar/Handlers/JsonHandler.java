package com.example.kisaanbazaar.Handlers;

import android.content.Context;
import android.util.Log;

import com.example.kisaanbazaar.Models.Account;
import com.example.kisaanbazaar.Models.Products;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static com.example.kisaanbazaar.Utils.Constants.ADDRESS_PINCODE;
import static com.example.kisaanbazaar.Utils.Constants.ADDRESS_STATE;
import static com.example.kisaanbazaar.Utils.Constants.ADDRESS_SUB;
import static com.example.kisaanbazaar.Utils.Constants.ADRRESS_DISTRICT;
import static com.example.kisaanbazaar.Utils.Constants.JSON_ACCOUNTS;
import static com.example.kisaanbazaar.Utils.Constants.JSON_PRODUCTS;

public class JsonHandler {

    private static final String TAG = JsonHandler.class.getSimpleName();
    private Context mContext;

    public JsonHandler(Context mContext) {
        this.mContext = mContext;
    }

    public List<Products> getAllProducts(){

        List<Products> mProductsList = new ArrayList<>();
        try {


            JSONArray jsonArray = new JSONArray(loadJSONFromAsset(JSON_PRODUCTS));
            JSONObject jsonObject;


            for(int n = 0; n < jsonArray.length(); n++)
            {
                jsonObject = jsonArray.getJSONObject(n);
                Log.d(TAG, "getAllProducts: "+ jsonObject.toString());


                List<String> offersList = new ArrayList<>();
                JSONArray offersJson = (JSONArray) jsonObject.get("avail_offers");
                for (int i=0; i<offersJson.length(); i++){
                    offersList.add(offersJson.getString(i));
                }


                List<String> favouritesList = new ArrayList<>();
                JSONArray favouritesJson = (JSONArray) jsonObject.get("favourites");
                for (int i=0; i<favouritesJson.length(); i++){
                    favouritesList.add(favouritesJson.getString(i));
                }


                JSONObject addressJson = (JSONObject) jsonObject.get("address");
                Map<String,String> address = new HashMap<>();
                address.put(ADDRESS_SUB,addressJson.getString(ADDRESS_SUB));
                address.put(ADRRESS_DISTRICT,addressJson.getString(ADRRESS_DISTRICT));
                address.put(ADDRESS_STATE,addressJson.getString(ADDRESS_STATE));
                address.put(ADDRESS_PINCODE,addressJson.getString(ADDRESS_PINCODE));


                Products products = new Products(jsonObject.getInt("product_id"),
                        jsonObject.getString("name"),
                        jsonObject.getString("description"),
                        jsonObject.getString("category"),
                        jsonObject.getString("sub_category"),
                        jsonObject.getString("thumbnail"),
                        jsonObject.getString("updated_on"),
                        offersList,
                        favouritesList,
                        jsonObject.getInt("price"),
                        jsonObject.getInt("quantity"),
                        jsonObject.getString("quantity_type"),
                        jsonObject.getString("owner_uid"),
                        jsonObject.getInt("status"),
                        address
                );
                mProductsList.add(products);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mProductsList;
    }

    public List<Account> getAllAccounts(){

        List<Account> mAccountsList = new ArrayList<>();

        try {


            JSONArray jsonArray = new JSONArray(loadJSONFromAsset(JSON_ACCOUNTS));
            JSONObject jsonObject;


            for(int n = 0; n < jsonArray.length(); n++)
            {
                jsonObject = jsonArray.getJSONObject(n);
                Log.d(TAG, "getAllAccounts: "+ jsonObject.toString());


                List<String> offersList = new ArrayList<>();
                JSONArray offersJson = (JSONArray) jsonObject.get("applied_offers");
                for (int i=0; i<offersJson.length(); i++){
                    offersList.add(offersJson.getString(i));
                }


                JSONObject addressJson = (JSONObject) jsonObject.get("address");
                Map<String,String> address = new HashMap<>();
                address.put(ADDRESS_SUB,addressJson.getString(ADDRESS_SUB));
                address.put(ADRRESS_DISTRICT,addressJson.getString(ADRRESS_DISTRICT));
                address.put(ADDRESS_STATE,addressJson.getString(ADDRESS_STATE));
                address.put(ADDRESS_PINCODE,addressJson.getString(ADDRESS_PINCODE));


                Account account = new Account(jsonObject.getString("uid"),
                        jsonObject.getString("name"),
                        jsonObject.getString("profile_image"),
                        jsonObject.getString("account_type"),
                        jsonObject.getString("login_type"),
                        jsonObject.getString("gender"),
                        jsonObject.getString("email"),
                        jsonObject.getInt("phone"),
                        jsonObject.getBoolean("is_verified"),
                        offersList,
                        address
                );
                mAccountsList.add(account);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return mAccountsList;
    }


    private String loadJSONFromAsset(String json_file) {
        String json;
        try {
            InputStream is = mContext.getAssets().open(json_file);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

}
