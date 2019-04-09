package bysykkel.client.station;

import com.google.gson.annotations.SerializedName;

public class Station {

        public Integer id;
        public String title;

        @SerializedName("number_of_locks")
        public Integer numberOfLocks;

}
