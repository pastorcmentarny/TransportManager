package com.dominiksymonowicz.transportmanager.domain.stations;

import java.util.Arrays;

import static com.dominiksymonowicz.transportmanager.domain.stations.StationType.*;

public enum StationName {
    ACTON_TOWN("Acton Town", TUBE),
    ALDGATE("Aldgate", TUBE),
    ALDGATE_EAST("Aldgate East", TUBE),
    ALPERTON("Alperton", TUBE),
    AMERSHAM("Amersham", TUBE),
    ANGEL("Angel", TUBE),
    ARCHWAY("Archway", TUBE),
    ARNOS_GROVE("Arnos Grove", TUBE),
    ARSENAL("Arsenal", TUBE),
    BAKER_STREET("Baker Street", TUBE),
    BALHAM("Balham", TUBE),
    BANK("Bank", TUBE),
    BARBICAN("Barbican", TUBE),
    BARKING("Barking", TUBE_OVERGROUND),
    BARKINGSIDE("Barkingside", TUBE),
    BARONS_COURT("Barons Court", TUBE),
    BAYSWATER("Bayswater", TUBE),
    BECONTREE("Becontree", TUBE),
    BELSIZE_PARK("Belsize Park", TUBE),
    BERMONDSEY("Bermondsey", TUBE),
    BETHNAL_GREEN("Bethnal Green", TUBE_OVERGROUND),
    BLACKFRIARS("Blackfriars", TUBE),
    BLACKHORSE_ROAD("Blackhorse Road", TUBE_OVERGROUND),
    BOND_STREET("Bond Street", TUBE),
    BOROUGH("Borough", TUBE),
    BOSTON_MANOR("Boston Manor", TUBE),
    BOUNDS_GREEN("Bounds Green", TUBE),
    BOW_ROAD("Bow Road", TUBE),
    BRENT_CROSS("Brent Cross", TUBE),
    BRIXTON("Brixton", TUBE),
    BROMLEY_BY_BOW("Bromley-by-Bow", TUBE),
    BUCKHURST_HILL("Buckhurst Hill", TUBE),
    BURNT_OAK("Burnt Oak", TUBE),
    CALEDONIAN_ROAD("Caledonian Road", TUBE),
    CAMDEN_TOWN("Camden Town", TUBE),
    CANADA_WATER("Canada Water", TUBE_OVERGROUND),
    CANARY_WHARF("Canary Wharf", TUBE),
    CANNING_TOWN("Canning Town", TUBE),
    CANNON_STREET("Cannon Street", TUBE),
    CANNONS_PARK("Cannons Park", TUBE),
    CHALFONT_AND_LATIMER("Chalfont & Latimer", TUBE),
    CHALK_FARM("Chalk Farm", TUBE),
    CHANCERY_LANE("Chancery Lane", TUBE),
    CAMDEN("Camden", TUBE),
    CHARING_CROSS("Charing Cross", TUBE),
    CHESHAM("Chesham", TUBE),
    CHIGWELL("Chigwell", TUBE),
    CHISWICK_PARK("Chiswick Park", TUBE),
    CHORLEYWOOD("Chorleywood", TUBE),
    CLAPHAM_COMMON("Clapham Common", TUBE),
    CLAPHAM_NORTH("Clapham North", TUBE),
    CLAPHAM_SOUTH("Clapham South", TUBE),
    COCKFOSTERS("Cockfosters", TUBE),
    COLINDALE("Colindale", TUBE),
    COLLIERS_WOOD("Colliers Wood", TUBE),
    COVENT_GARDEN("Covent Garden", TUBE),
    CROXLEY("Croxley", TUBE),
    DAGENHAM_EAST("Dagenham East", TUBE),
    DAGENHAM_HEATHWAY("Dagenham Heathway", TUBE),
    DEBDEN("Debden", TUBE),
    DOLLIS_HILL("Dollis Hill", TUBE),
    EALING_BROADWAY("Ealing Broadway", TUBE),
    EALING_COMMON("Ealing Common", TUBE),
    EARLS_COURT("Earl's Court", TUBE),
    EAST_ACTON("East Acton", TUBE),
    EAST_FINCHLEY("East Finchley", TUBE),
    EAST_HAM("East Ham", TUBE),
    EAST_PUTNEY("East Putney", TUBE),
    EASTCOTE("Eastcote", TUBE),
    EDGWARE("Edgware", TUBE),
    EDGWARE_ROAD("Edgware Road", TUBE),
    ELEPHANT_AND_CASTLE("Elephant & Castle", TUBE),
    ELM_PARK("Elm Park", TUBE),
    EMBANKMENT("Embankment", TUBE),
    EPPING("Epping", TUBE),
    EUSTON("Euston", TUBE_OVERGROUND),
    EUSTON_SQUARE("Euston Square", TUBE),
    FAIRLOP("Fairlop", TUBE),
    FARRINGDON("Farringdon", TUBE),
    FINCHLEY_CENTRAL("Finchley Central", TUBE),
    FINCHLEY_ROAD("Finchley Road", TUBE),
    FINSBURY_PARK("Finsbury Park", TUBE),
    FULHAM_BROADWAY("Fulham Broadway", TUBE),
    GANTS_HILL("Gants Hill", TUBE),
    GLOUCESTER_ROAD("Gloucester Road", TUBE),
    GOLDERS_GREEN("Golders Green", TUBE),
    GOLDHAWK_ROAD("Goldhawk Road", TUBE),
    GOODGE_STREET("Goodge Street", TUBE),
    GRANGE_HILL("Grange Hill", TUBE),
    GREAT_PORTLAND_STREET("Great Portland Street", TUBE),
    GREENFORD("Greenford", TUBE),
    GREEN_PARK("Green Park", TUBE),
    GUNNERSBURY("Gunnersbury", TUBE_OVERGROUND),
    HAINAULT("Hainault", TUBE),
    HAMMERSMITH("Hammersmith", TUBE),
    HAMPSTEAD("Hampstead", TUBE),
    HANGER_LANE("Hanger Lane", TUBE),
    HARLESDEN("Harlesden", TUBE_OVERGROUND),
    HARROW_AND_WEALDSTONE("Harrow & Wealdstone", TUBE_OVERGROUND),
    HARROW_ON_THE_HILL("Harrow-on-the-Hill", TUBE),
    HATTON_CROSS("Hatton Cross", TUBE),
    HEATHROW_TERMINALS_1_2_3("Heathrow Terminals 1, 2, 3", TUBE),
    HEATHROW_TERMINAL_4("Heathrow Terminal 4", TUBE),
    HEATHROW_TERMINAL_5("Heathrow Terminal 5", TUBE),
    HENDON_CENTRAL("Hendon Central", TUBE),
    HIGH_BARNET("High Barnet", TUBE),
    HIGHBURY_AND_ISLINGTON("Highbury & Islington", TUBE_OVERGROUND),
    HIGHGATE("Highgate", TUBE),
    HIGH_STREET_KENSINGTON("High Street Kensington", TUBE),
    HILLINGDON("Hillingdon", TUBE),
    HOLBORN("Holborn", TUBE),
    HOLLAND_PARK("Holland Park", TUBE),
    HOLLOWAY_ROAD("Holloway Road", TUBE),
    HORNCHURCH("Hornchurch", TUBE),
    HOUNSLOW_CENTRAL("Hounslow Central", TUBE),
    HOUNSLOW_EAST("Hounslow East", TUBE),
    HOUNSLOW_WEST("Hounslow West", TUBE),
    HYDE_PARK_CORNER("Hyde Park Corner", TUBE),
    ICKENHAM("Ickenham", TUBE),
    KENNINGTON("Kennington", TUBE),
    KENSAL_GREEN("Kensal Green", TUBE_OVERGROUND),
    KENSINGTON_OLYMPIA("KENSINGTON (Olympia)", TUBE_OVERGROUND),
    KENTISH_TOWN("Kentish Town", TUBE),
    KENTON("Kenton", TUBE_OVERGROUND),
    HARROW("Harrow", TUBE),
    KEW_GARDENS("Kew Gardens", TUBE_OVERGROUND),
    KILBURN("Kilburn", TUBE),
    KILBURN_PARK("Kilburn Park", TUBE),
    KINGSBURY("Kingsbury", TUBE),
    KINGS_CROSS_ST_PANCRAS("King's Cross St. Pancras", TUBE),
    KNIGHTSBRIDGE("Knightsbridge", TUBE),
    LADBROKE_GROVE("Ladbroke Grove", TUBE),
    LAMBETH_NORTH("Lambeth North", TUBE),
    LANCASTER_GATE("Lancaster Gate", TUBE),
    LATIMER_ROAD("Latimer Road", TUBE),
    LEICESTER_SQUARE("Leicester Square", TUBE),
    LEYTON("Leyton", TUBE),
    LEYTONSTONE("Leytonstone", TUBE),
    LIVERPOOL_STREET("Liverpool Street", TUBE_OVERGROUND),
    LONDON_BRIDGE("London Bridge", TUBE),
    LOUGHTON("Loughton", TUBE),
    MAIDA_VALE("Maida Vale", TUBE),
    MANOR_HOUSE("Manor House", TUBE),
    MANSION_HOUSE("Mansion House", TUBE),
    MARBLE_ARCH("Marble Arch", TUBE),
    MARYLEBONE("Marylebone", TUBE),
    MILE_END("Mile End", TUBE),
    MILL_HILL_EAST("Mill Hill East", TUBE),
    MONUMENT("Monument", TUBE),
    MOORGATE("Moorgate", TUBE),
    MOOR_PARK("Moor Park", TUBE),
    MORDEN("Morden", TUBE),
    MORNINGTON_CRESCENT("Mornington Crescent", TUBE),
    NEASDEN("Neasden", TUBE),
    NEWBURY_PARK("Newbury Park", TUBE),
    NORTH_ACTON("North Acton", TUBE),
    NORTH_EALING("North Ealing", TUBE),
    NORTH_GREENWICH("North Greenwich", TUBE),
    NORTH_HARROW("North Harrow", TUBE),
    NORTH_WEMBLEY("North Wembley", TUBE_OVERGROUND),
    NORTHFIELDS("Northfields", TUBE),
    NORTHOLT("Northolt", TUBE),
    NORTHWICK_PARK("Northwick Park", TUBE),
    NORTHWOOD("Northwood", TUBE),
    NORTHWOOD_HILLS("Northwood Hills", TUBE),
    NOTTING_HILL_GATE("Notting Hill Gate", TUBE),
    OAKWOOD("Oakwood", TUBE),
    OLD_STREET("Old Street", TUBE),
    OSTERLEY("Osterley", TUBE),
    OVAL("Oval", TUBE),
    OXFORD_CIRCUS("Oxford Circus", TUBE),
    PADDINGTON("Paddington", TUBE),
    PARK_ROYAL("Park Royal", TUBE),
    PARSONS_GREEN("Parsons Green", TUBE),
    PERIVALE("Perivale", TUBE),
    PICCADILLY_CIRCUS("Piccadilly Circus", TUBE),
    PIMLICO("Pimlico", TUBE),
    PINNER("Pinner", TUBE),
    PLAISTOW("Plaistow", TUBE),
    PRESTON_ROAD("Preston Road", TUBE),
    PUTNEY_BRIDGE("Putney Bridge", TUBE),
    QUEENS_PARK("Queen's Park", TUBE_OVERGROUND),
    QUEENSBURY("Queensbury", TUBE),
    QUEENSWAY("Queensway", TUBE),
    RAVENSCOURT_PARK("Ravenscourt Park", TUBE),
    RAYNERS_LANE("Rayners Lane", TUBE),
    REDBRIDGE("Redbridge", TUBE),
    REGENTS_PARK("Regent's Park", TUBE),
    RICHMOND("Richmond", TUBE_OVERGROUND),
    RICKMANSWORTH("Rickmansworth", TUBE),
    RODING_VALLEY("Roding Valley", TUBE),
    ROYAL_OAK("Royal Oak", TUBE),
    RUISLIP("Ruislip", TUBE),
    RUISLIP_GARDENS("Ruislip Gardens", TUBE),
    RUISLIP_MANOR("Ruislip Manor", TUBE),
    RUSSELL_SQUARE("Russell Square", TUBE),
    ST_JAMESS_PARK("St. James's Park", TUBE),
    ST_JOHNS_WOOD("St. John's Wood", TUBE),
    ST_PAULS("St. Paul's", TUBE),
    SEVEN_SISTERS("Seven Sisters", TUBE_OVERGROUND),
    SHEPHERDS_BUSH("Shepherd's Bush", TUBE_OVERGROUND),
    SHEPHERDS_BUSH_MARKET("Shepherd's Bush Market", TUBE),
    SLOANE_SQUARE("Sloane Square", TUBE),
    SNARESBROOK("Snaresbrook", TUBE),
    SOUTH_EALING("South Ealing", TUBE),
    SOUTH_HARROW("South Harrow", TUBE),
    SOUTH_KENSINGTON("South Kensington", TUBE),
    SOUTH_KENTON("South Kenton", TUBE_OVERGROUND),
    SOUTH_RUISLIP("South Ruislip", TUBE),
    SOUTH_WIMBLEDON("South Wimbledon", TUBE),
    SOUTH_WOODFORD("South Woodford", TUBE),
    SOUTHFIELDS("Southfields", TUBE),
    SOUTHGATE("Southgate", TUBE),
    SOUTHWARK("Southwark", TUBE),
    STAMFORD_BROOK("Stamford Brook", TUBE),
    STANMORE("Stanmore", TUBE),
    STEPNEY_GREEN("Stepney Green", TUBE),
    STOCKWELL("Stockwell", TUBE),
    STONEBRIDGE_PARK("Stonebridge Park", TUBE_OVERGROUND),
    STRATFORD("Stratford", TUBE_OVERGROUND),
    SUDBURY_HILL("Sudbury Hill", TUBE),
    SUDBURY_TOWN("Sudbury Town", TUBE),
    EALING("Ealing", TUBE),
    SWISS_COTTAGE("Swiss Cottage", TUBE),
    TEMPLE("Temple", TUBE),
    THEYDON_BOIS("Theydon Bois", TUBE),
    TOOTING_BEC("Tooting Bec", TUBE),
    TOOTING_BROADWAY("Tooting Broadway", TUBE),
    TOTTENHAM_COURT_ROAD("Tottenham Court Road", TUBE),
    TOTTENHAM_HALE("Tottenham Hale", TUBE),
    TOTTERIDGE_AND_WHETSTONE("Totteridge & Whetstone", TUBE),
    TOWER_HILL("Tower Hill", TUBE),
    TUFNELL_PARK("Tufnell Park", TUBE),
    TURNHAM_GREEN("Turnham Green", TUBE),
    TURNPIKE_LANE("Turnpike Lane", TUBE),
    UPMINSTER("Upminster", TUBE_OVERGROUND),
    UPMINSTER_BRIDGE("Upminster Bridge", TUBE),
    UPNEY("Upney", TUBE),
    UPTON_PARK("Upton Park", TUBE),
    UXBRIDGE("Uxbridge", TUBE),
    VAUXHALL("Vauxhall", TUBE),
    VICTORIA("Victoria", TUBE),
    WALTHAMSTOW_CENTRAL("Walthamstow Central", TUBE_OVERGROUND),
    WANSTEAD("Wanstead", TUBE),
    WARREN_STREET("Warren Street", TUBE),
    WARWICK_AVENUE("Warwick Avenue", TUBE),
    WATERLOO("Waterloo", TUBE),
    WATFORD("Watford", TUBE),
    WEMBLEY_CENTRAL("Wembley Central", TUBE_OVERGROUND),
    WEMBLEY_PARK("Wembley Park", TUBE),
    WEST_ACTON("West Acton", TUBE),
    WEST_BROMPTON("West Brompton", TUBE_OVERGROUND),
    WEST_FINCHLEY("West Finchley", TUBE),
    WEST_HAM("West Ham", TUBE),
    WEST_HAMPSTEAD("West Hampstead", TUBE_OVERGROUND),
    WEST_HARROW("West Harrow", TUBE),
    WEST_KENSINGTON("West Kensington", TUBE),
    WEST_RUISLIP("West Ruislip", TUBE),
    WESTBOURNE_PARK("Westbourne Park", TUBE),
    WESTMINSTER("Westminster", TUBE),
    WHITE_CITY("White City", TUBE),
    WHITECHAPEL("Whitechapel", TUBE_OVERGROUND),
    WILLESDEN_GREEN("Willesden Green", TUBE),
    WILLESDEN_JUNCTION("Willesden Junction", TUBE_OVERGROUND),
    WIMBLEDON("Wimbledon", TUBE),
    WIMBLEDON_PARK("Wimbledon Park", TUBE),
    WOOD_GREEN("Wood Green", TUBE),
    WOOD_LANE("Wood Lane", TUBE),
    WOODFORD("Woodford", TUBE),
    WOODSIDE_PARK("Woodside Park", TUBE),
    ACTON_CENTRAL("Acton Central", OVERGROUND),
    ANERLEY("Anerley", OVERGROUND),
    BATTERSEA_PARK("Battersea Park", OVERGROUND),
    BROCKLEY("Brockley", OVERGROUND),
    BRONDESBURY_PARK("Brondesbury Park", OVERGROUND),
    BRONDESBURY("Brondesbury", OVERGROUND),
    BRUCE_GROVE("Bruce Grove", OVERGROUND),
    BUSH_HILL_PARK("Bush Hill Park", OVERGROUND),
    BUSHEY("Bushey", OVERGROUND),
    CALEDONIAN_ROAD_AND_BARNSBURY("Caledonian Road & Barnsbury", OVERGROUND),
    CAMBRIDGE_HEATH("Cambridge Heath", OVERGROUND),
    CAMDEN_ROAD("Camden Road", OVERGROUND),
    CANONBURY("Canonbury", OVERGROUND),
    CARPENDERS_PARK("Carpenders Park", OVERGROUND),
    CHESHUNT("Cheshunt", OVERGROUND),
    CHINGFORD("Chingford", OVERGROUND),
    CLAPHAM_HIGH_STREET("Clapham High Street", OVERGROUND),
    CLAPHAM_JUNCTION("Clapham Junction", OVERGROUND),
    CLAPTON("Clapton", OVERGROUND),
    CROUCH_HILL("Crouch Hill", OVERGROUND),
    CRYSTAL_PALACE("Crystal Palace", OVERGROUND),
    DALSTON_JUNCTION("Dalston Junction", OVERGROUND),
    DALSTON_KINGSLAND("Dalston Kingsland", OVERGROUND),
    DENMARK_HILL("Denmark Hill", OVERGROUND),
    EDMONTON_GREEN("Edmonton Green", OVERGROUND),
    EMERSON_PARK("Emerson Park", OVERGROUND),
    ENFIELD_TOWN("Enfield Town", OVERGROUND),
    FINCHLEY_ROAD_AND_FROGNAL("Finchley Road & Frognal", OVERGROUND),
    FOREST_HILL("Forest Hill", OVERGROUND),
    GOSPEL_OAK("Gospel Oak", OVERGROUND),
    HACKNEY_CENTRAL("Hackney Central", OVERGROUND),
    HACKNEY_DOWNS("Hackney Downs", OVERGROUND),
    HACKNEY_WICK("Hackney Wick", OVERGROUND),
    HAGGERSTON("Haggerston", OVERGROUND),
    HAMPSTEAD_HEATH("Hampstead Heath", OVERGROUND),
    HARRINGAY_GREEN_LANES("Harringay Green Lanes", OVERGROUND),
    HATCH_END("Hatch End", OVERGROUND),
    HEADSTONE_LANE("Headstone Lane", OVERGROUND),
    HIGHAMS_PARK("Highams Park", OVERGROUND),
    HOMERTON("Homerton", OVERGROUND),
    HONOR_OAK_PARK("Honor Oak Park", OVERGROUND),
    HOXTON("Hoxton", OVERGROUND),
    IMPERIAL_WHARF("Imperial Wharf", OVERGROUND),
    KENSAL_RISE("Kensal Rise", OVERGROUND),
    KENTISH_TOWN_WEST("Kentish Town West", OVERGROUND),
    KILBURN_HIGH_ROAD("Kilburn High Road", OVERGROUND),
    LEYTON_MIDLAND_ROAD("Leyton Midland Road", OVERGROUND),
    LEYTONSTONE_HIGH_ROAD("Leytonstone High Road", OVERGROUND),
    LONDON_FIELDS("London Fields", OVERGROUND),
    NEW_CROSS_GATE("New Cross Gate", OVERGROUND),
    NEW_CROSS("New Cross", OVERGROUND),
    NORWOOD_JUNCTION("Norwood Junction", OVERGROUND),
    PECKHAM_RYE("Peckham Rye", OVERGROUND),
    PENGE_WEST("Penge West", OVERGROUND),
    QUEENS_ROAD_PECKHAM("Queens Road Peckham", OVERGROUND),
    RECTORY_ROAD("Rectory Road", OVERGROUND),
    ROMFORD("Romford", OVERGROUND),
    ROTHERHITHE("Rotherhithe", OVERGROUND),
    ST_JAMES_STREET("St. James Street", OVERGROUND),
    SHADWELL("Shadwell", OVERGROUND),
    SHOREDITCH_HIGH_STREET("Shoreditch High Street", OVERGROUND),
    SILVER_STREET("Silver Street", OVERGROUND),
    SOUTH_ACTON("South Acton", OVERGROUND),
    SOUTH_HAMPSTEAD("South Hampstead", OVERGROUND),
    SOUTH_TOTTENHAM("South Tottenham", OVERGROUND),
    SOUTHBURY("Southbury", OVERGROUND),
    STAMFORD_HILL("Stamford Hill", OVERGROUND),
    STOKE_NEWINGTON("Stoke Newington", OVERGROUND),
    SURREY_QUAYS("Surrey Quays", OVERGROUND),
    SYDENHAM("Sydenham", OVERGROUND),
    THEOBALDS_GROVE("Theobalds Grove", OVERGROUND),
    TURKEY_STREET("Turkey Street", OVERGROUND),
    UPPER_HOLLOWAY("Upper Holloway", OVERGROUND),
    WALTHAMSTOW_QUEENS_ROAD("Walthamstow Queen's Road", OVERGROUND),
    WANDSWORTH_ROAD("Wandsworth Road", OVERGROUND),
    WANSTEAD_PARK("Wanstead Park", OVERGROUND),
    WAPPING("Wapping", OVERGROUND),
    WATFORD_HIGH_STREET("Watford High Street", OVERGROUND),
    WATFORD_JUNCTION("Watford Junction", OVERGROUND),
    WEST_CROYDON("West Croydon", OVERGROUND),
    WHITE_HART_LANE("White Hart Lane", OVERGROUND),
    WOOD_STREET("Wood Street", OVERGROUND),
    WOODGRANGE_PARK("Woodgrange Park", OVERGROUND);

    private final String stationName;
    private final StationType stationType;

    StationName(String stationName, StationType stationType) {
        this.stationName = stationName;
        this.stationType = stationType;
    }

    public static boolean has(String stationName) {
        return Arrays.stream(StationName.values()).anyMatch(it -> it.getStationName().equalsIgnoreCase(stationName));
    }

    public String getStationName() {
        return stationName;
    }

    public StationType getStationType() {
        return stationType;
    }
}