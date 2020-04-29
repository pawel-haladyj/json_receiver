package pl.haladyj.wzjsontemplate.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import pl.haladyj.wzjsontemplate.model.Wz;
import pl.haladyj.wzjsontemplate.payload.WzContent;
import pl.haladyj.wzjsontemplate.repository.WzRepository;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public class WzUtils {

    @Value("${wz.prefix}")
    private String wzPrefix;

    private Long index = 1L;

    private final WzRepository wzRepository;

    public WzUtils(WzRepository wzRepository) {
        this.wzRepository = wzRepository;
    }

    public String createSn() {
        Instant date = Instant.now();
        int currentYear = Date.from(date).getYear() + 1900;
        int lastSnYear = 0;

        Optional<String> lastSn = wzRepository.findMostRecentSnFromWz();
        String currentSn = "";

        int index = 0;

        if (lastSn.isPresent()) {
            String lastSnExisting = lastSn.get();
            int lastIndexOfSlash = lastSnExisting.lastIndexOf("/");
            lastSnYear = Integer.parseInt(lastSnExisting.substring(lastIndexOfSlash - 4, lastIndexOfSlash));

            index = Integer.parseInt(lastSnExisting.substring(lastIndexOfSlash + 1));
            index++;

            currentSn = wzPrefix + currentYear + "/" + index;
        } else {
            currentSn = wzPrefix + currentYear + "/1";
        }
        if (lastSnYear != currentYear) {
            currentSn = wzPrefix + currentYear + "/1";
        }
        return currentSn;
    }

    public Instant now() {
        return Instant.now();
    }

    public Map<String, WzContent> updateMapContent(Wz wz) {
        Map<String, WzContent> products = wz.getProducts();
        Map<String, WzContent> changedKeyMap = new HashMap<>();

        String sn = createSn();

/*        products
                .entrySet()
                .stream()
                .filter()
                .forEach(result -> {
                    Long index = 1L;
                    String key = sn + "/" + index.toString();
                    changedKeyMap.put(key, result.getValue());
                    index++;
                });*/

        products.forEach((k, v) -> {
            changedKeyMap.put(sn + '/' + index++, v);
        });
        index = 1L;
        return changedKeyMap;
    }
}
