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

            while(recordIterator.hasNext())
            {

            }



    }

}

