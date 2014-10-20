package cdba;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * ========== ItCorp v. 1.0 class library ==========
 * <p/>
 * http://www.it.ru/
 * <p/>
 * &copy; Copyright 1990-2013, by ItCorp.
 * <p/>
 * ========== cdba.Application.java ==========
 * <p/>
 * $Revision:  $<br/>
 * $Author:  $<br/>
 * $HeadURL:  $<br/>
 * $Id:  $
 * <p/>
 * 20.10.14 19:38: Original version (ilya)<br/>
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan
public class Application implements CommandLineRunner {

    @Autowired
    SqlToTimeExecutor sqlToTimeExecutor;

    @Value("${sql.template.filepath}")
    String sqlFilepath;

    @Value("${output.filepath}")
    String outputFilepath;




    public static void main(String[] args) throws Throwable {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        String sql = FileUtils.readFileToString(new File(sqlFilepath));
        File outputFile = new File(outputFilepath+ File.separator + format(new Date(), "yyyy-MM-dd")+ ".csv");
        outputFile.getParentFile().mkdirs();

        List<String> results =new ArrayList<String>();
        results.add(format(new Date(), "yyyy-MM-dd HH:mm:ss"));

        SqlExecResult sqlExecResult = sqlToTimeExecutor.executeQuery(sql);

        results.add(sqlExecResult.getTime().toString());
        results.add(sqlExecResult.getRowCount().toString());
        results.add(sqlExecResult.getSql());
        FileUtils.writeStringToFile(outputFile, StringUtils.join(results, ";")+"\n", true);
    }

    public static String format(Date date, String format) {
        Locale local = new Locale("ru", "RU");
        DateFormatSymbols russSymbol = new DateFormatSymbols(local);
        SimpleDateFormat sdf = new SimpleDateFormat(format, russSymbol);
        return sdf.format(date.getTime());
    }

}
