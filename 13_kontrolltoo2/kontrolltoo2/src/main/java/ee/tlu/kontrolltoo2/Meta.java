package ee.tlu.kontrolltoo2;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Getter
@NoArgsConstructor
public class Meta {
    public String publisher;
    public String licence;
    public String documentation;
    public String version;
    public String comment;
    public ArrayList<String> hasFormat;
}
