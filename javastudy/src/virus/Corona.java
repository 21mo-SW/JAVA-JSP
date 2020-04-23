
package virus;

import java.util.List;

import lombok.Data;

@Data
public class Corona {

    private Integer count;
    private String page;
    private List<StoreInfo> storeInfos = null;
    private Integer totalCount;
    private Integer totalPages;

}
