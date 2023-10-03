package hello.typeconverter.formatter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.fomatter.MyNumberFormatter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();

        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());

        conversionService.addFormatter(new MyNumberFormatter());

        IpPort result = conversionService.convert("127.0.0.0:8080", IpPort.class);
        Assertions.assertThat(result).isEqualTo(new IpPort("127.0.0.0", 8080));

        String convert = conversionService.convert(1000, String.class);
        Assertions.assertThat(convert).isEqualTo("1,000");

    }
}
