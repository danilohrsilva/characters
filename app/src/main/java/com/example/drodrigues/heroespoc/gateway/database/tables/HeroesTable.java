package com.example.drodrigues.heroespoc.gateway.database.tables;

import android.database.sqlite.SQLiteStatement;

import com.example.drodrigues.heroespoc.entity.Character;
import com.example.drodrigues.heroespoc.entity.CharacterType;
import com.example.drodrigues.heroespoc.infrastructure.Constants;
import com.example.drodrigues.heroespoc.infrastructure.Constants.Database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HeroesTable {

    private HeroesTable() {
    }

    public static final String TABLE_NAME = "heroes";

    public static final String ID = "_id";
    public static final String DATA = "data";

    public static final String SQL_INSERT = Database.INSERT_INTO + TABLE_NAME
            + Database.TABLE_SEPARATOR_OPEN + DATA
            + Database.TABLE_SEPARATOR_CLOSE + Database.VALUES + Database.TABLE_SEPARATOR_OPEN
            + Database.BIND_CHAR + Database.TABLE_SEPARATOR_CLOSE + Database.LINE_SEPARATOR;

    private static int START_ID = 0;

    private static final List<String> ALL_COLUMNS = Collections
            .unmodifiableList(Arrays.asList(ID, DATA));

    public static String[] getAllColumns() {
        return ALL_COLUMNS.toArray(new String[ALL_COLUMNS.size()]);
    }

    public static final String SQL_CREATE =
            Database.CREATE_TABLE + TABLE_NAME + Database.TABLE_SEPARATOR_OPEN
                    + ID + Database.COLUMN_TYPE_PK + Database.COLUMN_SEPARATOR
                    + DATA + Database.COLUMN_TYPE_STRING + Database.TABLE_SEPARATOR_CLOSE;

    private static final List<Character> INITIAL_CHARACTERS = new ArrayList<>(Arrays.asList(
            new Character("Batman",
                    "Bruce Wayne",
                    "Batman is a fictional superhero appearing in American comic books published by DC Comics. The character was created by artist Bob Kane and writer Bill Finger,[4][5] and first appeared in Detective Comics #27 (1939). Originally named the \"Bat-Man\", the character is also referred to by such epithets as the Caped Crusader, the Dark Knight, and the World's Greatest Detective.[6]\n" +
                    "\n" +
                    "Batman's secret identity is Bruce Wayne, a wealthy American playboy, philanthropist, and owner of Wayne Enterprises. After witnessing the murder of his parents Dr. Thomas Wayne and Martha Wayne as a child, he swore vengeance against criminals, an oath tempered by a sense of justice. Bruce Wayne trains himself physically and intellectually and crafts a bat-inspired persona to fight crime.[7]\n" +
                    "\n" +
                    "Batman operates in the fictional Gotham City with assistance from various supporting characters, including his butler Alfred, police commissioner Gordon, and vigilante allies such as Robin. Unlike most superheroes, Batman does not possess any superpowers; rather, he relies on his genius intellect, physical prowess, martial arts abilities, detective skills, science and technology, vast wealth, intimidation, and indomitable will. A large assortment of villains make up Batman's rogues gallery, including his archenemy, the Joker.\n" +
                    "\n" +
                    "The character became popular soon after his introduction in 1939 and gained his own comic book title, Batman, the following year. As the decades went on, differing interpretations of the character emerged. The late 1960s Batman television series used a camp aesthetic, which continued to be associated with the character for years after the show ended. Various creators worked to return the character to his dark roots, culminating in 1986 with The Dark Knight Returns by Frank Miller. The success of Warner Bros.' live-action Batman feature films have helped maintain the character's prominence in mainstream culture.[8]\n" +
                    "\n" +
                    "An American cultural icon, Batman has garnered enormous popularity and is among the most identifiable comic book characters. Batman has been licensed and featured in various adaptations, from radio to television and film, and appears on merchandise sold around the world, such as apparel, toys, and video games. The character has also intrigued psychiatrists, with many trying to understand his psyche. In 2015, FanSided ranked Batman as number one on their list of \"50 Greatest Super Heroes In Comic Book History\".[9] Kevin Conroy, Bruce Greenwood, Peter Weller, Anthony Ruivivar, Jason O'Mara, and Will Arnett, among others, have provided the character's voice for animated adaptations. Batman has been depicted in both film and television by Lewis Wilson, Robert Lowery, Adam West, Michael Keaton, Val Kilmer, George Clooney, Christian Bale, and Ben Affleck.",
                    "https://images.vexels.com/media/users/17482/122067/raw/c54c2aed3949cf58bdf5a8586d2cddff-vector-batman.png",
                    CharacterType.HERO),
            new Character("Superman",
                    "Clark Kent",
                    "Superman is a fictional superhero appearing in American comic books published by DC Comics. The character was created by writer Jerry Siegel and artist Joe Shuster, high school students living in Cleveland, Ohio, in 1933. They sold Superman to Detective Comics, the future DC Comics, in 1938. Superman debuted in Action Comics #1 (cover-dated June 1938) and subsequently appeared in various radio serials, newspaper strips, television programs, films, and video games. With this success, Superman helped to create the superhero archetype and establish its primacy within the American comic book.[2] The character is also referred to by such epithets as the Big Blue Boy Scout, the Man of Steel, the Man of Tomorrow, and the Last Son of Krypton.[3]\n" +
                            "\n" +
                            "The origin story of Superman relates that he was born Kal-El on the planet Krypton, before being rocketed to Earth as an infant by his scientist father Jor-El, moments before Krypton's destruction. Discovered and adopted by a farm couple from Kansas, the child is raised as Clark Kent and imbued with a strong moral compass. Early in his childhood, he displays various superhuman abilities, which, upon reaching maturity, he resolves to use for the benefit of humanity through a \"Superman\" identity.\n" +
                            "\n" +
                            "Superman resides and operates in the fictional American city of Metropolis. As Clark Kent, he is a journalist for the Daily Planet, a Metropolis newspaper. Superman's love interest is Lois Lane, and his archenemy is the supervillain Lex Luthor. A close ally of Batman and Wonder Woman, he is typically depicted as a member of the Justice League. Like other characters in the DC Universe, several alternative versions of Superman have been characterized over the years.\n" +
                            "\n" +
                            "Superman's appearance is distinctive and iconic; he usually wears a blue costume with a red-and-yellow emblem on the chest, consisting of the letter S in a shield shape, and a red cape. This shield is used in many media to symbolize the character. Superman is widely considered an American cultural icon.[2][4][5][6] He has fascinated scholars, with cultural theorists, commentators, and critics alike exploring the character's role and impact in the United States and worldwide. The character's ownership has often been the subject of dispute, with Siegel and Shuster twice suing for the return of rights. The character has been portrayed in many media adaptations as well, including films, television series, and video games. Several actors have played Superman in motion pictures and TV series including Bud Collyer, Kirk Alyn, George Reeves, Christopher Reeve, Dean Cain, Tim Daly, Tom Welling, Brandon Routh, Henry Cavill, and Tyler Hoechlin.",
                    "https://upload.wikimedia.org/wikipedia/en/thumb/e/eb/SupermanRoss.png/250px-SupermanRoss.png",
                    CharacterType.HERO),
            new Character("The Flash",
                    "Barry Allen",
                    "The Flash (or simply Flash) is the name of several superheroes appearing in comic books published by DC Comics. Created by writer Gardner Fox and artist Harry Lampert, the original Flash first appeared in Flash Comics #1 (cover date January 1940/release month November 1939).[1] Nicknamed the \"Scarlet Speedster\", all incarnations of the Flash possess \"super speed\", which includes the ability to run, move, and think extremely fast, use superhuman reflexes, and seemingly violate certain laws of physics.\n" +
                            "\n" +
                            "Thus far, at least four different characters—each of whom somehow gained the power of \"the speed force\"—have assumed the mantle of the Flash in DC's history: college athlete Jay Garrick (1940–1951, 1961–2011, 2017–present), forensic scientist Barry Allen (1956–1985, 2008–present), Barry's nephew Wally West (1986–2011, 2016–present), and Barry's grandson Bart Allen (2006–2007). Each incarnation of the Flash has been a key member of at least one of DC's premier teams: the Justice Society of America, the Justice League, and the Teen Titans.\n" +
                            "\n" +
                            "The Flash is one of DC Comics' most popular characters and has been integral to the publisher's many reality-changing \"crisis\" storylines over the years. The original meeting of the Golden Age Flash Jay Garrick and Silver Age Flash Barry Allen in \"Flash of Two Worlds\" (1961) introduced the Multiverse storytelling concept to DC readers, which would become the basis for many DC stories in the years to come.\n" +
                            "\n" +
                            "Like his Justice League colleagues Wonder Woman, Superman and Batman, the Flash has a distinctive cast of adversaries, including the various Rogues (unique among DC supervillains for their code of honor) and the various psychopathic \"speedsters\" who go by the names Reverse-Flash or Zoom. Other supporting characters in Flash stories include Barry's wife Iris West, Wally's wife Linda Park, Bart's girlfriend Valerie Perez, friendly fellow speedster Max Mercury, and Central City police department members David Singh and Patty Spivot.\n" +
                            "\n" +
                            "A staple of the comic book DC Universe, the Flash has been adapted to numerous DC films, video games, animated series, and live-action television shows. In live action, Barry Allen has been portrayed by Rod Haase for the 1979 television special Legends of the Superheroes, John Wesley Shipp and Grant Gustin in the 1990 The Flash series and the 2014 The Flash series, respectively, as well as by Ezra Miller in the DC Extended Universe series of films, beginning with Batman v Superman: Dawn of Justice (2016). Shipp also portrays a version of Jay Garrick in the 2014 The Flash series. The various incarnations of the Flash also feature in animated series such as Superman: The Animated Series, Justice League, Batman: The Brave and the Bold and Young Justice, as well as the DC Universe Animated Original Movies series.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTieTATG1WRQ76lUeyo3WZRRgr39nxOG_1eh_ah3IVYb4En0nlh",
                    CharacterType.HERO),
            new Character("Green Arrow",
                    "Oliver Queen",
                    "Green Arrow is a fictional superhero who appears in comic books published by DC Comics. Created by Mortimer Weisinger and designed by George Papp, he first appeared in More Fun Comics #73 in November 1941. His real name is Oliver Jonas Queen, a wealthy businessman and owner of Queen Industries who is also a well-known celebrity in Star City.[2] Sometimes shown dressed like the character Robin Hood, Green Arrow is an archer who uses his skills to fight crime in his home cities of Star City and Seattle, as well as alongside his fellow superheroes as a member of the Justice League. Though much less frequently used in modern stories, he also deploys a range of trick arrows with various special functions, such as glue, explosive-tipped, grappling hook, flash grenade, tear gas and even kryptonite arrows for use in a range of special situations. At the time of his debut, Green Arrow functioned in many ways as an archery-themed analogue of the very popular Batman character, but writers at DC subsequently developed him into a voice of left-wing politics very much distinct in character from Batman.\n" +
                            "\" +\n" +
                            "                \"\\n\" +\n" +
                            "                \"Green Arrow enjoyed moderate success in his early years, becoming the cover feature of More Fun, as well as having occasional appearances in other comics. Throughout his first twenty-five years, however, the character never enjoyed greater popularity. In the late 1960s, writer Denny O'Neil, inspired by the character's dramatic visual redesign by Neal Adams, chose to have him lose his fortune, giving him the then-unique role of a streetwise crusader for the working class and the disadvantaged. In 1970, he was paired with a more law and order-oriented hero, Green Lantern, in a ground-breaking, socially conscious comic book series.[3] Since then, he has been popular among comic book fans and most writers have taken an urban, gritty approach to the character. The character was killed off in the 1990s and replaced by a new character, Oliver's son Connor Hawke. Connor, however, proved a less popular character, and the original Oliver Queen character was resurrected in the 2001 \\\"Quiver\\\" storyline, by writer Kevin Smith. In the 2000s, the character has been featured in bigger storylines focusing on Green Arrow and Black Canary, such as the DC event The Green Arrow/Black Canary Wedding and the high-profile Justice League: Cry for Justice storyline, prior to the character's relaunch alongside most of DC's properties in 2011.\\n\" +\n" +
                            "                \"\\n\" +\n" +
                            "                \"Green Arrow was not initially a well-known character outside of comic book fandom: he had appeared in a single episode of the animated series Super Friends in 1973. In the 2000s, the character appeared in a number of DC television properties, including the animated series Justice League Unlimited, Young Justice, The Batman and Batman: The Brave and the Bold, and several DC Universe Animated Original Movies. In live action, he appeared in the series Smallville, played by actor Justin Hartley, and became a core cast member. In 2012, the live action series Arrow debuted on The CW, in which the title character is portrayed by Stephen Amell, earning positive reviews[4] and launching several spin-off series, becoming the starting point for a DC Comics shared television universe.",
                    "https://4.bp.blogspot.com/-Gf1-pIylWbw/VdjZ99YHDVI/AAAAAAAAlkM/F-s9CF6a93g/s320/435f6ac3a8f2afc6f8449f402be23c97.jpg",
                    CharacterType.HERO),
            new Character("Wonder Woman",
                    "Diana Prince",
                    "Wonder Woman is a fictional superhero appearing in American comic books published by DC Comics.[2] The character is a founding member of the Justice League, goddess, and Ambassador-at-Large of the Amazon people. The character first appeared in All Star Comics #8 in October 1941 and first cover-dated on Sensation Comics #1, January 1942. In her homeland, the island nation of Themyscira, her official title is Princess Diana of Themyscira, Daughter of Hippolyta. When blending into the society outside of her homeland, she adopts her civilian identity Diana Prince. The character is also referred to by such epithets as the \"Amazing Amazon\", the \"Spirit of Truth\", \"Themyscira's Champion\", the \"God-Killer\", and the \"Goddess of Love and War\".\n" +
                            "\" +\n" +
                            "                \"\\n\" +\n" +
                            "                \"Wonder Woman was created by the American psychologist and writer William Moulton Marston (pen name: Charles Moulton),[2] and artist Harry G. Peter. Olive Byrne, Marston's lover, and his wife, Elizabeth,[3] are credited as being his inspiration for the character's appearance.[2][4][5][6][7] Marston drew a great deal of inspiration from early feminists, and especially from birth control pioneer Margaret Sanger; in particular, her piece \\\"Woman and the New Race\\\". The Wonder Woman title has been published by DC Comics almost continuously except for a brief hiatus in 1986.[8]\\n\" +\n" +
                            "                \"\\n\" +\n" +
                            "                \"Wonder Woman's origin story relates that she was sculpted from clay by her mother Queen Hippolyta and given life by Aphrodite, along with superhuman powers as gifts by the Greek gods. In recent years, DC changed her background with the revelation that she is the daughter of Zeus and Hippolyta, jointly raised by her mother and her aunts Antiope and Menalippe. In the 1980s artist George Perez gave her a muscular look and emphasized her Amazonian heritage.[9][10] Wonder Woman's Amazonian training helped to develop a wide range of extraordinary skills in tactics, hunting, and combat. She possesses an arsenal of advanced technology, including the Lasso of Truth, a pair of indestructible bracelets, a tiara which serves as a projectile, and, in older stories, a range of devices based on Amazon technology. Wonder Woman's character was created during World War II; the character in the story was initially depicted fighting Axis military forces as well as an assortment of colorful supervillains, although over time her stories came to place greater emphasis on characters, deities, and monsters from Greek mythology. Many stories depicted Wonder Woman rescuing herself from bondage, which defeated the \\\"damsels in distress\\\" trope that was common in comics during the 1940s.[11] In the decades since her debut, Wonder Woman has gained a cast of enemies bent on eliminating the Amazon, including classic villains such as Ares, Cheetah, Doctor Poison, Circe, Doctor Psycho, and Giganta, along with more recent adversaries such as Veronica Cale and the First Born. Wonder Woman has also regularly appeared in comic books featuring the superhero teams Justice Society (from 1941) and Justice League (from 1960).[12]\\n\" +\n" +
                            "                \"\\n\" +\n" +
                            "                \"The character is a well-known figure in popular culture that has been adapted to various media. Notable depictions of the character in other media include Gloria Steinem placing the character on the cover of the second edition of Ms. magazine in 1971; the 1975–1979 Wonder Woman TV series starring Lynda Carter; as well as animated series such as the Super Friends and Justice League. Since Carter's television series, studios struggled to introduce a new live-action Wonder Woman to audiences, although the character continued to feature in a variety of toys and merchandise, as well as animated adaptations of DC properties, including a direct-to-DVD animated feature starring Keri Russell. Attempts to return Wonder Woman to television have included a television pilot for NBC in 2011,[13] closely followed by another stalled production for The CW.[14][15] Gal Gadot portrays Wonder Woman in the DC Extended Universe, starting with the 2016 film Batman v Superman: Dawn of Justice, marking the character's second appearance in a feature film (The Lego Movie (2014) is the first as an animated character) in its 75-year history.[16] Gadot also starred in the character's first solo live-action film, Wonder Woman, which was released on June 2, 2017.[17][18]",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTdPEQVIKF6GeopPCeGxG4iitDTPxy4LFZCmWXYeAVGsNk5yNzz8g",
                    CharacterType.HERO),
            new Character("Martian Manhunter",
                    "J'onn J'onzz",
                    "The Martian Manhunter (J'onn J'onzz) is a fictional superhero appearing in American comic books published by DC Comics. Created by writer Joseph Samachson and designed by artist Joe Certa, the character first appeared in the story \"The Manhunter from Mars\" in Detective Comics #225 (Nov. 1955). Martian Manhunter is one of the seven original members of the Justice League of America and one of the most powerful beings in the DC Universe.\n" +
                            "\n" +
                            "J'onzz has featured in other DC Comics-endorsed products, such as video games, television series, animated films, and merchandise like action figures and trading cards. The character was ranked #43 on IGN's greatest comic book hero list.[1] J'onzz was played by David Ogden Stiers in the 1997 Justice League of America live-action television pilot. Phil Morris also portrayed him in the television series Smallville. David Harewood portrays a human form of Martian Manhunter on Supergirl.",
                    "http://2.bp.blogspot.com/-9mShMBscA7E/VkzXDEZEQTI/AAAAAAAAFPk/v8UfckgbvXw/s640/Martian_Manhunter_h3.jpg",
                    CharacterType.HERO),
            new Character("Green Lantern",
                    "Hal Jordan",
                    "Green Lantern is the name of several superheroes appearing in American comic books published by DC Comics. They fight evil with the aid of rings that grant them a variety of extraordinary powers.\n" +
                            "\" +\n" +
                            "                \"\\n\" +\n" +
                            "                \"The first Green Lantern character, Alan Scott, was created in 1940 by Martin Nodell during the initial popularity of superheroes. Alan Scott usually fought common criminals in New York City with the aid of his magic ring.\\n\" +\n" +
                            "                \"\\n\" +\n" +
                            "                \"The Green Lanterns are among DC Comics' longer lasting sets of characters. They have been adapted to television, video games, and motion pictures.",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7RQnk04qXjgVsyB86YvJ0hw3Rx1w7DkNWFbjjpMFA7_lOYwzDvw",
                    CharacterType.HERO),
            new Character("Aquaman",
                    "Arthur Curry",
                    "Aquaman is a fictional superhero appearing in American comic books published by DC Comics. Created by Paul Norris and Mort Weisinger, the character debuted in More Fun Comics #73 (November 1941).[1] Initially a backup feature in DC's anthology titles, Aquaman later starred in several volumes of a solo comic book series. During the late 1950s and 1960s superhero-revival period known as the Silver Age, he was a founding member of the Justice League. In the 1990s Modern Age, writers interpreted Aquaman's character more seriously, with storylines depicting the weight of his role as king of Atlantis.[2]\n" +
                            "\n" +
                            "The character's original 1960s animated appearances left a lasting impression, making Aquaman widely recognized in popular culture. Jokes about his wholesome, weak portrayal in Super Friends and perceived feeble powers and abilities have been staples of comedy programs and stand-up routines,[3] leading DC at several times to attempt to make the character edgier or more powerful in comic books. Modern comic book depictions have attempted to reconcile these various aspects of his public perception, casting Aquaman as serious and brooding, saddled with an ill reputation, and struggling to find a true role and purpose beyond his public side as a deposed king and a fallen hero.[4]\n" +
                            "\n" +
                            "Aquaman has been featured in several adaptations, first appearing in animated form in the 1967 The Superman/Aquaman Hour of Adventure and then in the related Super Friends program. Since then he has appeared in various animated productions, including prominent roles in the 2000s series Justice League Unlimited and Batman: The Brave and the Bold, as well as several DC Universe Animated Original Movies. Actor Alan Ritchson also portrayed the character in the live-action television show Smallville. Within the DC Extended Universe, American actor Jason Momoa portrayed the character in the films Batman v Superman: Dawn of Justice (2016) and Justice League (2017). Momoa will reprise his role in the upcoming solo film Aquaman, scheduled for release in 2018.[5][6][7]",
                    "https://i.pinimg.com/564x/ea/35/ee/ea35ee975de339eb8f78c89c5b9a901e--arthur-curry-aquaman.jpg",
                    CharacterType.HERO),
            new Character("Hawkwoman",
                    "Shayera Hol",
                    "Hawkwoman is the name of several fictional superheroines all owned by DC Comics and existing in that company's DC Universe. They are partners, and sometimes spouses or lovers, of the various versions of Hawkman, and share many features with the character Hawkgirl.",
                    "http://www.comicbookreligion.com/img/h/a/Hawkwoman_Shayera_Thal.jpg",
                    CharacterType.HERO),
            new Character("Joker",
                    "(Name unknown)",
                    "The Joker is a fictional supervillain created by Bill Finger, Bob Kane, and Jerry Robinson who first appeared in the debut issue of the comic book Batman (April 25, 1940), published by DC Comics. Credit for the Joker's creation is disputed; Kane and Robinson claimed responsibility for the Joker's design, while acknowledging Finger's writing contribution. Although the Joker was planned to be killed off during his initial appearance, he was spared by editorial intervention, allowing the character to endure as the archenemy of the superhero Batman.\n" +
                            "\n" +
                            "In his comic book appearances, the Joker is portrayed as a criminal mastermind. Introduced as a psychopath with a warped, sadistic sense of humor, the character became a goofy prankster in the late 1950s in response to regulation by the Comics Code Authority, before returning to his darker roots during the early 1970s. As Batman's nemesis, the Joker has been part of the superhero's defining stories, including the murder of Jason Todd—the second Robin and Batman's ward—and the paralysis of one of Batman's allies, Barbara Gordon. The Joker has had various possible origin stories during his decades of appearances. The most common story involves him falling into a tank of chemical waste which bleaches his skin white, turns his hair green, and his lips bright red; the resulting disfigurement drives him insane. The antithesis of Batman in personality and appearance, the Joker is considered by critics to be his perfect adversary.\n" +
                            "\n" +
                            "The Joker possesses no superhuman abilities, instead using his expertise in chemical engineering to develop poisonous or lethal concoctions, and thematic weaponry, including razor-tipped playing cards, deadly joy buzzers, and acid-spraying lapel flowers. The Joker sometimes works with other Gotham City supervillains such as the Penguin and Two-Face, and groups like the Injustice Gang and Injustice League, but these relationships often collapse due to the Joker's desire for unbridled chaos. The 1990s introduced a romantic interest for the Joker in his former psychiatrist, Harley Quinn, who becomes his villainous sidekick. Although his primary obsession is Batman, the Joker has also fought other heroes including Superman and Wonder Woman.\n" +
                            "\n" +
                            "One of the most iconic characters in popular culture, the Joker has been listed among the greatest comic book villains and fictional characters ever created. The character's popularity has seen him appear on a variety of merchandise, such as clothing and collectable items, inspire real-world structures (such as theme park attractions), and be referenced in a number of media. The Joker has been adapted to serve as Batman's adversary in live-action, animated, and video game incarnations, including the 1960s Batman television series (played by Cesar Romero) and in film by Jack Nicholson in Batman (1989), Heath Ledger in The Dark Knight (2008), and Jared Leto in Suicide Squad (2016). Mark Hamill, Troy Baker, and others have provided the character's voice.",
                    "http://media.4rgos.it/i/Argos/6512152_R_Z001A?$Web$&$DefaultPDP570$",
                    CharacterType.VILLAIN),
            new Character("Lex Luthor",
                    "Alexander Joseph Luthor",
                    "\"Lex\" Alexander Joseph Luthor is a fictional supervillain appearing in American comic books published by DC Comics, though on occasions he has established himself as an antihero. He was created by Jerry Siegel and Joe Shuster. Lex Luthor first appeared in Action Comics #23 (April 1940) and has since endured as the archenemy of Superman.[1]\n" +
                            "\n" +
                            "Lex Luthor is a wealthy, power-mad American business magnate, ingenious engineer, philanthropist to the city of Metropolis, and one of the most intelligent people in the world. A charismatic and well-known public figure, he is the owner of a corporation called LexCorp, with Mercy Graves as his personal assistant and bodyguard. He is intent on ridding the world of the alien Superman, whom Lex Luthor views as an obstacle to his megalomaniacal plans and as a threat to the very existence of humanity.[2] Given his high status as a supervillain, he has often come into conflict with Batman and other superheroes in the DC Universe.[3]\n" +
                            "\n" +
                            "The character has traditionally lacked superpowers or a dual identity and typically appears with a bald head.[3] He periodically wears his Warsuit, a high-tech battle suit giving him enhanced strength, flight, advanced weaponry, and other capabilities.[4] The character was originally introduced as a diabolical recluse, but during the Modern Age, he was reimagined by writers as a devious, high-profile industrialist, who has crafted his public persona in order to avoid suspicion and arrest. He is well known for his philanthropy, donating vast sums of money to Metropolis over the years, funding parks, foundations, and charities.[5]\n" +
                            "\n" +
                            "The character was ranked 4th on IGN's list of the Top 100 Comic Book Villains of All Time[6] and as the 8th Greatest Villain by Wizard on its 100 Greatest Villains of All Time list.[7] Luthor is one of a few genre-crossing villains whose adventures take place \"in a world in which the ordinary laws of nature are slightly suspended\".[4] Scott James Wells, Sherman Howard, John Shea, and Michael Rosenbaum portrayed the character in Superman-themed television series, while Lyle Talbot, Gene Hackman, Kevin Spacey, and Jesse Eisenberg have portrayed the character in major motion pictures. Clancy Brown, Powers Boothe, James Marsters, Chris Noth, Anthony LaPaglia, Steven Blum, Fred Tatasciore, Jason Isaacs, Kevin Michael Richardson, Mark Rolston, John DiMaggio, James Woods, and others have provided the character's voice in animation adaptations.",
                    "https://pre00.deviantart.net/348b/th/pre/f/2015/048/d/9/how_to_draw_dc_villains___lex_luthor_by_timlevins-d8iflfl.jpg",
                    CharacterType.VILLAIN),
            new Character("Reverse-Flash",
                    "Eobard Thawne",
                    "Reverse-Flash is a name which has been used by several fictional supervillains in American comic books published by DC Comics. Each iteration is an enemy of the hero known as The Flash. As each version of the Flash has the power to travel at super-speeds, each version of Reverse-Flash can also travel at super-speeds, allowing them to travel back and forth in time. The fact that the each two have the same power is much of the reason they are enemies. There have been many different characters that have been known as Reverse-Flash",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5DN1HKfbdfkq4tcK1SHt2HQSTEAfIcWHEd42o6Dqgn7KZYhEg",
                    CharacterType.VILLAIN),
            new Character("Deathstroke",
                    "Slade Joseph Wilson",
                    "Deathstroke (Slade Joseph Wilson) is a fictional supervillain appearing in American comic books published by DC Comics. The character was created by Marv Wolfman and George Pérez. He is a mercenary and assassin who first appeared in The New Teen Titans #2 (December 1980).[1] Wizard magazine rated him the 24th Greatest Villain of All Time.[2]\n" +
                            "\n" +
                            "Though he is the archenemy of the Teen Titans, writers have developed him over the years as an adversary of other heroes in the DC Universe as well, including Batman and Green Arrow. The character has been substantially adapted from the comics into multiple forms of media, including several Batman-related projects and the Teen Titans animated series. He is portrayed on The CW's live-action TV series Arrow by Manu Bennett, and by Joe Manganiello in the feature films of the DC Extended Universe, beginning with a cameo in 2017's Justice League.",
                    "https://hqrock.files.wordpress.com/2011/05/deathstroke.jpg",
                    CharacterType.VILLAIN),
            new Character("Ares",
                    "",
                    "Ares (also known as Mars) is a fictional supervillain appearing in comic books published by DC Comics. Based on the Greek mythological figure of the same name, he is the Greek god of war and serves as the nemesis of the superhero Wonder Woman within the DC Universe.\n" +
                            "\n" +
                            "The character has appeared in various forms of media. Alfred Molina voiced him in the 2009 direct-to-video animated movie Wonder Woman. Ares later made his live-action debut in the 2017 film Wonder Woman, where he is portrayed by English actor David Thewlis.[1][2",
                    "https://upload.wikimedia.org/wikipedia/en/2/25/AresDC2.png",
                    CharacterType.VILLAIN),
            new Character("Black Manta",
                    "David Hyde",
                    "Black Manta is one of Aquaman's greatest villains. His lethal high-tech suit allows him to survive underwater and adapt to any number of situations with an arsenal of destructive weaponry. Despite his prominence, Manta remains an enigmatic figure, his identity and his origins kept secret. The motivation for his villainy is a deep-seated hatred for the sea due to strong emotional reasons, and a personal vendetta against Aquaman. He has also been a member of O.G.R.E., the Injustice League, the Secret Society of Super-Villains, the Sinestro Corps and the Suicide Squad. Black Manta was created by Bob Haney and Nick Cardy, first appearing in Aquaman #35. (1967)",
                    "http://www.rapsheet.co.uk/Images/Characters/BlackManta.jpg",
                    CharacterType.VILLAIN),
            new Character("Sinestro",
                    "Thaal Sinestro",
                    "Thaal Sinestro is a fictional supervillain appearing in American comic books published by DC Comics. Sinestro is a former Green Lantern Corps member who was dishonorably discharged for abusing his power. He is the archenemy of Hal Jordan and founder of the Sinestro Corps.",
                    "https://pre00.deviantart.net/a2f6/th/pre/f/2015/052/e/c/how_to_draw_dc_villains___sinestro_by_timlevins-d8ixowu.jpg",
                    CharacterType.VILLAIN)));

    private static String getInsertHero(final Character character) {
        START_ID = START_ID++;
        return Database.INSERT_INTO + TABLE_NAME + Database.TABLE_SEPARATOR_OPEN
                + ID + Database.COLUMN_SEPARATOR + DATA + Database.TABLE_SEPARATOR_CLOSE
                + Database.VALUES + Database.TABLE_SEPARATOR_OPEN + START_ID + Database.COLUMN_SEPARATOR
                + Database.STRING_SEPARATOR + Constants.gson.toJson(character) + Database.STRING_SEPARATOR
                + Database.TABLE_SEPARATOR_CLOSE + Database.LINE_SEPARATOR;
    }

    public static String getInsertInitialHeroes() {
        final StringBuilder sql = new StringBuilder();
        for (final Character character : INITIAL_CHARACTERS) {
            sql.append(getInsertHero(character));
        }
        return sql.toString();
    }

    public static void insertInitialHeroes(final SQLiteStatement statement) {
        for (final Character character : INITIAL_CHARACTERS) {
            statement.clearBindings();
            statement.bindString(1, Constants.gson.toJson(character));
            statement.execute();
        }
    }

}
