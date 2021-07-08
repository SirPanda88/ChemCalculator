import java.io.*;

public class ElementInfoPrinter {
    // Prints element symbols and required information from a csv file and selected columns to pass into
    // constructor arguments for the Element enum

    // Must specify numerical vs String columns, selected column numbers indexed from 0
    // Data mostly taken from https://www.data-explorer.com/data/
    // -1 used for undefined atomic radii, electronegativities, and first ionization potentials
    // Holes filled with andrejewski/periodic-table repo on Github

    public static void print(String csvFile, int[] numericalCols, int[] stringCols) {
        if (csvFile == null || numericalCols == null || stringCols == null) {
            throw new IllegalArgumentException("Null parameter");
        }
        FileReader fr;
        BufferedReader br = null;
        try {
            File file = new File(csvFile);
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String currentLine;
            String[] separatedCells;
            StringBuilder printedLine;

            currentLine = br.readLine();
            while (currentLine != null) {
                separatedCells = currentLine.split(",");
                printedLine = new StringBuilder(separatedCells[2] + "(");
                for (int numericalCol : numericalCols) {
                    printedLine.append(separatedCells[numericalCol]).append(", ");
                }
                for (int i = 0; i<stringCols.length - 1; i++) {
                    printedLine.append("\"").append(separatedCells[stringCols[i]]).append("\"").append(", ");
                }

                printedLine.append("\"").append(separatedCells[stringCols[stringCols.length - 1]]).append("\"").append("),");

                System.out.println(printedLine);
                currentLine = br.readLine();
            }
            System.out.println(";");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeReader(br);
        }
    }

    private static void closeReader(Reader reader) {
        try {
            if (reader != null) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // csv file to read
        String csvFile = "C:\\Users\\ezhan\\STEMcalcs\\dataexplorerdata(atomic weights).csv";
        ElementInfoPrinter.print(csvFile, new int[]{0, 3, 4, 5, 10, 11, 12}, new int[]{1, 2, 8, 20});
    }
}


