package workpresence;

/**
 * Created by tachyonpek on 2014-2015.
 * @author tachyonpek
 */

        import java.io.File;
        import java.io.IOException;
        import java.text.Format;
        import java.text.SimpleDateFormat;
        import java.util.Iterator;
        import java.util.List;
        import nl.knaw.dans.common.dbflib.CorruptedTableException;
        import nl.knaw.dans.common.dbflib.DbfLibException;
        import nl.knaw.dans.common.dbflib.Field;
        import nl.knaw.dans.common.dbflib.IfNonExistent;
        import nl.knaw.dans.common.dbflib.Record;
        import nl.knaw.dans.common.dbflib.Table;
        import nl.knaw.dans.common.dbflib.ValueTooLargeException;

public class Vypis7
{
    public static void main(String[] args)
    {
        int hodina;
        int minuta;
        int mes;
        int denvmes;
        int minutzaden;
        int minutzatyden = 0;
        int mabytzatyden = 0;
        int minutaudalosti;
        int minutaudalosti1 = 0;
        int minutaudalosti2 = 0;
        int predchminutaudalosti = 0;
        int currentDenVMes = 0;
        int pocetpovinnychdnu = 0;
        int odpracovanoZaDanyDenMinut = 0;
        int kumulOdpracovanoZaDanyDenMinut = 0;
        int zbytkoveminuty;
        boolean pracuji = false;
        if(args.length != 0)
        {
            System.out.println("One argument required: table to dump");
            System.exit(1);
        }

        //final Table table = new Table(new File(args[0]));
        final Table table = new Table(new File("/home/il/DATAFILE.dbf"));

        //int prvnidenvtydnu = Integer.parseInt(args[1]) ;
        int prvnidenvtydnu = 26 ;


        // int pocetuznanychdni = Integer.parseInt(args[2]) ; // pro tydny kdy mam dovolenou, nemoc nebo skoleni

        System.out.println(prvnidenvtydnu) ;

        try
        {
            table.open(IfNonExistent.ERROR);

            final Format dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("TABLE PROPERTIES");
            System.out.println("Name          : " + table.getName());
            System.out.println("Last Modified : " + dateFormat.format(table.getLastModifiedDate()));
            System.out.println("--------------");
            System.out.println();
            System.out.println("FIELDS (COLUMNS)");

            final List<Field> fields = table.getFields();

            for(final Field field: fields)
            {
                System.out.println("  Name       : " + field.getName());
                System.out.println("  Type       : " + field.getType());
                System.out.println("  Length     : " + field.getLength());
                System.out.println("  Dec. Count : " + field.getDecimalCount());
                System.out.println();
            }

            System.out.println("--------------");
            System.out.println();
            System.out.println("RECORDS");

            final Iterator<Record> recordIterator = table.recordIterator();
            int count = 0;

            pracuji = false; // nepouziva se
            minutaudalosti1 = 0;
            minutaudalosti2 = 0;
            predchminutaudalosti = 0;
            while(recordIterator.hasNext())
            {
                final Record record = recordIterator.next();
                if (record.getNumberValue("CISLO").longValue() == new Long(1255)) // 189 
                {
                    System.out.println("-----"); 
                    System.out.print(record.getNumberValue("HOD").intValue() + ":");
                    System.out.println(record.getNumberValue("MIN").intValue());
                    System.out.println("-----"); 
                }

            }

        }
        catch(IOException ioe)
        {
            System.out.println("Trouble reading table or table not found");
            ioe.printStackTrace();
        }
        catch(DbfLibException dbflibException)
        {
            System.out.println("Problem getting raw value");
            dbflibException.printStackTrace();
        }




    }

}

