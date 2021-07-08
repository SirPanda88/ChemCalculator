import java.util.HashMap;
import java.util.Map;

public enum Element {

    H(1, 1.00794, 1, 1, 0.79, 2.2, 13.5984, "Hydrogen", "H", "Nonmetal", "1s1"),
    He(2, 4.002602, 1, 18, 0.49, -1, 24.5874, "Helium", "He", "Noble Gas", "1s2"),
    Li(3, 6.941, 2, 1, 2.1, 0.98, 5.3917, "Lithium", "Li", "Alkali Metal", "[He] 2s1"),
    Be(4, 9.012182, 2, 2, 1.4, 1.57, 9.3227, "Beryllium", "Be", "Alkaline Earth Metal", "[He] 2s2"),
    B(5, 10.811, 2, 13, 1.2, 2.04, 8.298, "Boron", "B", "Metalloid", "[He] 2s2 2p1"),
    C(6, 12.0107, 2, 14, 0.91, 2.55, 11.2603, "Carbon", "C", "Nonmetal", "[He] 2s2 2p2"),
    N(7, 14.0067, 2, 15, 0.75, 3.04, 14.5341, "Nitrogen", "N", "Nonmetal", "[He] 2s2 2p3"),
    O(8, 15.9994, 2, 16, 0.65, 3.44, 13.6181, "Oxygen", "O", "Nonmetal", "[He] 2s2 2p4"),
    F(9, 18.9984032, 2, 17, 0.57, 3.98, 17.4228, "Fluorine", "F", "Halogen", "[He] 2s2 2p5"),
    Ne(10, 20.1797, 2, 18, 0.51, -1, 21.5645, "Neon", "Ne", "Noble Gas", "[He] 2s2 2p6"),
    Na(11, 22.98976928, 3, 1, 2.2, 0.93, 5.1391, "Sodium", "Na", "Alkali Metal", "[Ne] 3s1"),
    Mg(12, 24.305, 3, 2, 1.7, 1.31, 7.6462, "Magnesium", "Mg", "Alkaline Earth Metal", "[Ne] 3s2"),
    Al(13, 26.9815386, 3, 13, 1.8, 1.61, 5.9858, "Aluminum", "Al", "Metal", "[Ne] 3s2 3p1"),
    Si(14, 28.0855, 3, 14, 1.5, 1.9, 8.1517, "Silicon", "Si", "Metalloid", "[Ne] 3s2 3p2"),
    P(15, 30.973762, 3, 15, 1.2, 2.19, 10.4867, "Phosphorus", "P", "Nonmetal", "[Ne] 3s2 3p3"),
    S(16, 32.065, 3, 16, 1.1, 2.58, 10.36, "Sulfur", "S", "Nonmetal", "[Ne] 3s2 3p4"),
    Cl(17, 35.453, 3, 17, 0.97, 3.16, 12.9676, "Chlorine", "Cl", "Halogen", "[Ne] 3s2 3p5"),
    Ar(18, 39.948, 3, 18, 0.88, -1, 15.7596, "Argon", "Ar", "Noble Gas", "[Ne] 3s2 3p6"),
    K(19, 39.0983, 4, 1, 2.8, 0.82, 4.3407, "Potassium", "K", "Alkali Metal", "[Ar] 4s1"),
    Ca(20, 40.078, 4, 2, 2.2, 1, 6.1132, "Calcium", "Ca", "Alkaline Earth Metal", "[Ar] 4s2"),
    Sc(21, 44.955912, 4, 3, 2.1, 1.36, 6.5615, "Scandium", "Sc", "Transition Metal", "[Ar] 3d1 4s2"),
    Ti(22, 47.867, 4, 4, 2, 1.54, 6.8281, "Titanium", "Ti", "Transition Metal", "[Ar] 3d2 4s2"),
    V(23, 50.9415, 4, 5, 1.9, 1.63, 6.7462, "Vanadium", "V", "Transition Metal", "[Ar] 3d3 4s2"),
    Cr(24, 51.9961, 4, 6, 1.9, 1.66, 6.7665, "Chromium", "Cr", "Transition Metal", "[Ar] 3d5 4s1"),
    Mn(25, 54.938045, 4, 7, 1.8, 1.55, 7.434, "Manganese", "Mn", "Transition Metal", "0.479"),
    Fe(26, 55.845, 4, 8, 1.7, 1.83, 7.9024, "Iron", "Fe", "Transition Metal", "[Ar] 3d6 4s2"),
    Co(27, 58.933195, 4, 9, 1.7, 1.88, 7.881, "Cobalt", "Co", "Transition Metal", "[Ar] 3d7 4s2"),
    Ni(28, 58.6934, 4, 10, 1.6, 1.91, 7.6398, "Nickel", "Ni", "Transition Metal", "[Ar] 3d8 4s2"),
    Cu(29, 63.546, 4, 11, 1.6, 1.9, 7.7264, "Copper", "Cu", "Transition Metal", "[Ar] 3d10 4s1"),
    Zn(30, 65.38, 4, 12, 1.5, 1.65, 9.3942, "Zinc", "Zn", "Transition Metal", "[Ar] 3d10 4s2"),
    Ga(31, 69.723, 4, 13, 1.8, 1.81, 5.9993, "Gallium", "Ga", "Metal", "[Ar] 3d10 4s2 4p1"),
    Ge(32, 72.64, 4, 14, 1.5, 2.01, 7.8994, "Germanium", "Ge", "Metalloid", "[Ar] 3d10 4s2 4p2"),
    As(33, 74.9216, 4, 15, 1.3, 2.18, 9.7886, "Arsenic", "As", "Metalloid", "[Ar] 3d10 4s2 4p3"),
    Se(34, 78.96, 4, 16, 1.2, 2.55, 9.7524, "Selenium", "Se", "Nonmetal", "[Ar] 3d10 4s2 4p4"),
    Br(35, 79.904, 4, 17, 1.1, 2.96, 11.8138, "Bromine", "Br", "Halogen", "[Ar] 3d10 4s2 4p5"),
    Kr(36, 83.798, 4, 18, 1, -1, 13.9996, "Krypton", "Kr", "Noble Gas", "[Ar] 3d10 4s2 4p6"),
    Rb(37, 85.4678, 5, 1, 3, 0.82, 4.1771, "Rubidium", "Rb", "Alkali Metal", "[Kr] 5s1"),
    Sr(38, 87.62, 5, 2, 2.5, 0.95, 5.6949, "Strontium", "Sr", "Alkaline Earth Metal", "[Kr] 5s2"),
    Y(39, 88.90585, 5, 3, 2.3, 1.22, 6.2173, "Yttrium", "Y", "Transition Metal", "[Kr] 4d1 5s2"),
    Zr(40, 91.224, 5, 4, 2.2, 1.33, 6.6339, "Zirconium", "Zr", "Transition Metal", "[Kr] 4d2 5s2"),
    Nb(41, 92.90638, 5, 5, 2.1, 1.6, 6.7589, "Niobium", "Nb", "Transition Metal", "[Kr] 4d4 5s1"),
    Mo(42, 95.96, 5, 6, 2, 2.16, 7.0924, "Molybdenum", "Mo", "Transition Metal", "[Kr] 4d5 5s1"),
    Tc(43, 98, 5, 7, 2, 1.9, 7.28, "Technetium", "Tc", "Transition Metal", "[Kr] 4d5 5s2"),
    Ru(44, 101.07, 5, 8, 1.9, 2.2, 7.3605, "Ruthenium", "Ru", "Transition Metal", "[Kr] 4d7 5s1"),
    Rh(45, 102.9055, 5, 9, 1.8, 2.28, 7.4589, "Rhodium", "Rh", "Transition Metal", "[Kr] 4d8 5s1"),
    Pd(46, 106.42, 5, 10, 1.8, 2.2, 8.3369, "Palladium", "Pd", "Transition Metal", "[Kr] 4d10"),
    Ag(47, 107.8682, 5, 11, 1.8, 1.93, 7.5762, "Silver", "Ag", "Transition Metal", "[Kr] 4d10 5s1"),
    Cd(48, 112.411, 5, 12, 1.7, 1.69, 8.9938, "Cadmium", "Cd", "Transition Metal", "[Kr] 4d10 5s2"),
    In(49, 114.818, 5, 13, 2, 1.78, 5.7864, "Indium", "In", "Metal", "[Kr] 4d10 5s2 5p1"),
    Sn(50, 118.71, 5, 14, 1.7, 1.96, 7.3439, "Tin", "Sn", "Metal", "[Kr] 4d10 5s2 5p2"),
    Sb(51, 121.76, 5, 15, 1.5, 2.05, 8.6084, "Antimony", "Sb", "Metalloid", "[Kr] 4d10 5s2 5p3"),
    Te(52, 127.6, 5, 16, 1.4, 2.1, 9.0096, "Tellurium", "Te", "Metalloid", "[Kr] 4d10 5s2 5p4"),
    I(53, 126.90447, 5, 17, 1.3, 2.66, 10.4513, "Iodine", "I", "Halogen", "[Kr] 4d10 5s2 5p5"),
    Xe(54, 131.293, 5, 18, 1.2, -1, 12.1298, "Xenon", "Xe", "Noble Gas", "[Kr] 4d10 5s2 5p6"),
    Cs(55, 132.9054519, 6, 1, 3.3, 0.79, 3.8939, "Cesium", "Cs", "Alkali Metal", "[Xe] 6s1"),
    Ba(56, 137.327, 6, 2, 2.8, 0.89, 5.2117, "Barium", "Ba", "Alkaline Earth Metal", "[Xe] 6s2"),
    La(57, 138.90547, 6, 3, 2.7, 1.1, 5.5769, "Lanthanum", "La", "Lanthanide", "[Xe] 5d1 6s2"),
    Ce(58, 140.116, 6, 19, 2.7, 1.12, 5.5387, "Cerium", "Ce", "Lanthanide", "[Xe] 4f1 5d1 6s2"),
    Pr(59, 140.90765, 6, 20, 2.7, 1.13, 5.473, "Praseodymium", "Pr", "Lanthanide", "[Xe] 4f3 6s2"),
    Nd(60, 144.242, 6, 21, 2.6, 1.14, 5.525, "Neodymium", "Nd", "Lanthanide", "[Xe] 4f4 6s2"),
    Pm(61, 145, 6, 22, 2.6, 1.13, 5.582, "Promethium", "Pm", "Lanthanide", "[Xe] 4f5 6s2"),
    Sm(62, 150.36, 6, 23, 2.6, 1.17, 5.6437, "Samarium", "Sm", "Lanthanide", "[Xe] 4f6 6s2"),
    Eu(63, 151.964, 6, 24, 2.6, 1.2, 5.6704, "Europium", "Eu", "Lanthanide", "[Xe] 4f7 6s2"),
    Gd(64, 157.25, 6, 25, 2.5, 1.2, 6.1501, "Gadolinium", "Gd", "Lanthanide", "[Xe] 4f7 5d1 6s2"),
    Tb(65, 158.92535, 6, 26, 2.5, 1.2, 5.8638, "Terbium", "Tb", "Lanthanide", "[Xe] 4f9 6s2"),
    Dy(66, 162.5, 6, 27, 2.5, 1.22, 5.9389, "Dysprosium", "Dy", "Lanthanide", "[Xe] 4f10 6s2"),
    Ho(67, 164.93032, 6, 28, 2.5, 1.23, 6.0215, "Holmium", "Ho", "Lanthanide", "[Xe] 4f11 6s2"),
    Er(68, 167.259, 6, 29, 2.5, 1.24, 6.1077, "Erbium", "Er", "Lanthanide", "[Xe] 4f12 6s2"),
    Tm(69, 168.93421, 6, 30, 2.4, 1.25, 6.1843, "Thulium", "Tm", "Lanthanide", "[Xe] 4f13 6s2"),
    Yb(70, 173.054, 6, 31, 2.4, 1.1, 6.2542, "Ytterbium", "Yb", "Lanthanide", "[Xe] 4f14 6s2"),
    Lu(71, 174.9668, 6, 32, 2.3, 1.27, 5.4259, "Lutetium", "Lu", "Lanthanide", "[Xe] 4f14 5d1 6s2"),
    Hf(72, 178.49, 6, 4, 2.2, 1.3, 6.8251, "Hafnium", "Hf", "Transition Metal", "[Xe] 4f14 5d2 6s2"),
    Ta(73, 180.94788, 6, 5, 2.1, 1.5, 7.5496, "Tantalum", "Ta", "Transition Metal", "[Xe] 4f14 5d3 6s2"),
    W(74, 183.84, 6, 6, 2, 2.36, 7.864, "Wolfram", "W", "Transition Metal", "[Xe] 4f14 5d4 6s2"),
    Re(75, 186.207, 6, 7, 2, 1.9, 7.8335, "Rhenium", "Re", "Transition Metal", "1925"),
    Os(76, 190.23, 6, 8, 1.9, 2.2, 8.4382, "Osmium", "Os", "Transition Metal", "[Xe] 4f14 5d6 6s2"),
    Ir(77, 192.217, 6, 9, 1.9, 2.2, 8.967, "Iridium", "Ir", "Transition Metal", "[Xe] 4f14 5d7 6s2"),
    Pt(78, 195.084, 6, 10, 1.8, 2.28, 8.9587, "Platinum", "Pt", "Transition Metal", "[Xe] 4f14 5d9 6s1"),
    Au(79, 196.966569, 6, 11, 1.8, 2.54, 9.2255, "Gold", "Au", "Transition Metal", "[Xe] 4f14 5d10 6s1"),
    Hg(80, 200.59, 6, 12, 1.8, 2, 10.4375, "Mercury", "Hg", "Transition Metal", "[Xe] 4f14 5d10 6s2"),
    Tl(81, 204.3833, 6, 13, 2.1, 2.04, 6.1082, "Thallium", "Tl", "Metal", "[Xe] 4f14 5d10 6s2 6p1"),
    Pb(82, 207.2, 6, 14, 1.8, 2.33, 7.4167, "Lead", "Pb", "Metal", "[Xe] 4f14 5d10 6s2 6p2"),
    Bi(83, 208.9804, 6, 15, 1.6, 2.02, 7.2856, "Bismuth", "Bi", "Metal", "[Xe] 4f14 5d10 6s2 6p3"),
    Po(84, 210, 6, 16, 1.5, 2, 8.417, "Polonium", "Po", "Metalloid", "[Xe] 4f14 5d10 6s2 6p4"),
    At(85, 210, 6, 17, 1.4, 2.2, 9.3, "Astatine", "At", "Noble Gas", "[Xe] 4f14 5d10 6s2 6p5"),
    Rn(86, 222, 6, 18, 1.3, -1, 10.7485, "Radon", "Rn", "Alkali Metal", "[Xe] 4f14 5d10 6s2 6p6"),
    Fr(87, 223, 7, 1, -1, 0.7, 4.0727, "Francium", "Fr", "Alkaline Earth Metal", "[Rn] 7s1"),
    Ra(88, 226, 7, 2, -1, 0.9, 5.2784, "Radium", "Ra", "Actinide", "[Rn] 7s2"),
    Ac(89, 227, 7, 3, -1, 1.1, 5.17, "Actinium", "Ac", "Actinide", "[Rn] 6d1 7s2"),
    Th(90, 232.03806, 7, 19, -1, 1.3, 6.3067, "Thorium", "Th", "Actinide", "[Rn] 6d2 7s2"),
    Pa(91, 231.03588, 7, 20, -1, 1.5, 5.89, "Protactinium", "Pa", "Actinide", "[Rn] 5f2 6d1 7s2"),
    U(92, 238.02891, 7, 21, -1, 1.38, 6.1941, "Uranium", "U", "Actinide", "[Rn] 5f3 6d1 7s2"),
    Np(93, 237, 7, 22, -1, 1.36, 6.2657, "Neptunium", "Np", "Actinide", "[Rn] 5f4 6d1 7s2"),
    Pu(94, 244, 7, 23, -1, 1.28, 6.0262, "Plutonium", "Pu", "Actinide", "[Rn] 5f6 7s2"),
    Am(95, 243, 7, 24, -1, 1.3, 5.9738, "Americium", "Am", "Actinide", "[Rn] 5f7 7s2"),
    Cm(96, 247, 7, 25, -1, 1.3, 5.9915, "Curium", "Cm", "Actinide", "[Rn] 5f7 6d1 7s2"),
    Bk(97, 247, 7, 26, -1, 1.3, 6.1979, "Berkelium", "Bk", "Actinide", "[Rn] 5f9 7s2"),
    Cf(98, 251, 7, 27, -1, 1.3, 6.2817, "Californium", "Cf", "Actinide", "[Rn] 5f10 7s2"),
    Es(99, 252, 7, 28, -1, 1.3, 6.42, "Einsteinium", "Es", "Actinide", "[Rn] 5f11 7s2"),
    Fm(100, 257, 7, 29, -1, 1.3, 6.5, "Fermium", "Fm", "Actinide", "[Rn] 5f12 7s2"),
    Md(101, 258, 7, 30, -1, 1.3, 6.58, "Mendelevium", "Md", "Actinide", "[Rn] 5f13 7s2"),
    No(102, 259, 7, 31, -1, 1.3, 6.65, "Nobelium", "No", "Actinide", "[Rn] 5f14 7s2"),
    Lr(103, 262, 7, 32, -1, -1, -1, "Lawrencium", "Lr", "Actinide", "[Rn] 5f14 7s2 7p1"),
    Rf(104, 261, 7, 4, -1, -1, -1, "Rutherfordium", "Rf", "Transactinide", "[Rn] 5f14 6d2 7s2"),
    Db(105, 262, 7, 5, -1, -1, -1, "Dubnium", "Db", "Transactinide", "[Rn] 5f14 6d3 7s2"),
    Sg(106, 266, 7, 6, -1, -1, -1, "Seaborgium", "Sg", "Transactinide", "[Rn] 5f14 6d4 7s2"),
    Bh(107, 264, 7, 7, -1, -1, -1, "Bohrium", "Bh", "Transactinide", "[Rn] 5f14 6d5 7s2"),
    Hs(108, 267, 7, 8, -1, -1, -1, "Hassium", "Hs", "Transactinide", "[Rn] 5f14 6d6 7s2"),
    Mt(109, 268, 7, 9, -1, -1, -1, "Meitnerium", "Mt", "Transactinide", "1982"),
    Ds (110, 271, 7, 10, -1, -1, -1, "Darmstadtium ", "Ds ", "Transactinide", "[Rn] 5f14 6d9 7s1"),
    Rg (111, 272, 7, 11, -1, -1, -1, "Roentgenium ", "Rg ", "Transactinide", "[Rn] 5f14 6d10 7s1"),
    Cn (112, 285, 7, 12, -1, -1, -1, "Copernicium ", "Cn ", "Transactinide", "[Rn] 5f14 6d10 7s2"),
    Nh(113, 284, 7, 13, -1, -1, -1, "Nihonium", "Nh", "Transactinide", "[Rn] 5f14 6d10 7s2 7p1"),
    Fl(114, 289, 7, 14, -1, -1, -1, "Flerovium", "Fl", "Transactinide", "[Rn] 5f14 6d10 7s2 7p2"),
    Mc(115, 288, 7, 15, -1, -1, -1, "Moscovium", "Mc", "Transactinide", "[Rn] 5f14 6d10 7s2 7p3"),
    Lv(116, 292, 7, 16, -1, -1, -1, "Livermorium", "Lv", "Transactinide", "[Rn] 5f14 6d10 7s2 7p4"),
    Ts(117, 295, 7, 17, -1, -1, -1, "Tennessine", "Ts", "Transactinide", "[Rn] 5f14 6d10 7s2 7p5"),
    Og(118, 294, 7, 18, -1, -1, -1, "Oganesson", "Og", "Noble Gas", "[Rn] 5f14 6d10 7s2 7p6");

    private static class Holder {
        static Map<Integer, Element> numberElementMap = new HashMap<Integer, Element>();
    }
    // numerical fields
    private final int atomicNumber;
    private final double atomicWeight;
    private final int period;
    private final int group;
    private final double atomicRadius;
    private final double electronegativity;
    private final double firstIonizationPotential;

    // String fields
    private final String fullName;
    private final String symbol;
    private final String type;
    private final String electronConfiguration;

    private Element(int atomicNumber, double atomicWeight, int period, int group,
                    double atomicRadius, double electronegativity, double firstIonizationPotential,
                    String fullName, String symbol, String type, String electronConfiguration) {
        this.atomicNumber = atomicNumber;
        this.atomicWeight = atomicWeight;
        this.period = period;
        this.group = group;
        this.atomicRadius = atomicRadius;
        this.electronegativity = electronegativity;
        this.firstIonizationPotential = firstIonizationPotential;
        this.fullName = fullName;
        this.symbol = symbol;
        this.type = type;
        this.electronConfiguration = electronConfiguration;
        Holder.numberElementMap.put(this.atomicNumber, this);
    }

    public static Element forAtomicNumber(int atomicNumber) {
        return Holder.numberElementMap.get(atomicNumber);
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public double getAtomicWeight() {
        return atomicWeight;
    }

    public int getPeriod() {
        return period;
    }

    public int getGroup() {
        return group;
    }

    public double getAtomicRadius() {
        return atomicRadius;
    }

    public double getElectronegativity() {
        return electronegativity;
    }

    public double getFirstIonizationPotential() {
        return firstIonizationPotential;
    }

    public String getFullName() {
        return fullName;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getType() {
        return type;
    }

    public String getElectronConfiguration() {
        return electronConfiguration;
    }
}