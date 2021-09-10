package top.pin90.quicker.dto.quicker;

import lombok.Data;
import top.pin90.quicker.dto.quicker.type.TypeResult;

import java.util.List;

@Data
public class QuickerResult {
    private int size;
    private List<TypeResult> results;

    public int getSize(){
        return results.size();
    }
}
