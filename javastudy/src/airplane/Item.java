package airplane;

import java.util.HashMap;
import java.util.Map;

public class Item {

private String airlineNm;
private String arrAirportNm;
private Long arrPlandTime;
private String depAirportNm;
private Long depPlandTime;
private String vihicleId;
private int economyCharge;
private int prestigeCharge;
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

public String getAirlineNm() {
return airlineNm;
}

public void setAirlineNm(String airlineNm) {
this.airlineNm = airlineNm;
}

public String getArrAirportNm() {
return arrAirportNm;
}

public void setArrAirportNm(String arrAirportNm) {
this.arrAirportNm = arrAirportNm;
}

public Long getArrPlandTime() {
return arrPlandTime;
}

public void setArrPlandTime(Long arrPlandTime) {
this.arrPlandTime = arrPlandTime;
}

public String getDepAirportNm() {
return depAirportNm;
}

public void setDepAirportNm(String depAirportNm) {
this.depAirportNm = depAirportNm;
}

public Long getDepPlandTime() {
return depPlandTime;
}

public void setDepPlandTime(Long depPlandTime) {
this.depPlandTime = depPlandTime;
}

public String getVihicleId() {
return vihicleId;
}

public void setVihicleId(String vihicleId) {
this.vihicleId = vihicleId;
}

public int getEconomyCharge() {
return economyCharge;
}

public void setEconomyCharge(int economyCharge) {
this.economyCharge = economyCharge;
}

public Integer getPrestigeCharge() {
return prestigeCharge;
}

public void setPrestigeCharge(Integer prestigeCharge) {
this.prestigeCharge = prestigeCharge;
}

public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}
