import GameState.GameStateConfiguration;
import GameState.GameStateFacade;
import MapDrawer.MapDrawerConfiguration;
import MapDrawer.MapDrawerFacade;
import PositionAIGenerator.PositionAIGeneratorConfiguration;
import PositionAIGenerator.PositionAIGeneratorFacade;
import PositionReceiver.Position;
import PositionReceiver.PositionReceiverConfiguration;
import PositionReceiver.PositionReceiverFacade;
import PositionReceiver.dto.PositionDto;
import PositionReceiver.dto.PositionReceiverResultDto;
import ResultChecker.ResultCheckerConfiguration;
import ResultChecker.ResultCheckerFacade;
import ResultChecker.dto.ResultCheckerDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        GameStateConfiguration gameStateConfiguration = new GameStateConfiguration();
        PositionAIGeneratorConfiguration positionAIGeneratorConfiguration = new PositionAIGeneratorConfiguration();
        MapDrawerConfiguration mapDrawerConfiguration = new MapDrawerConfiguration();
        PositionReceiverConfiguration positionReceiverConfiguration = new PositionReceiverConfiguration();
        ResultCheckerConfiguration resultCheckerConfiguration = new ResultCheckerConfiguration();


        Scanner scanner = new Scanner(System.in);
        System.out.println("Give me dimensions");
        String dimensions = scanner.nextLine();
        System.out.println("Give me number row to win");
        String rowToWin = scanner.nextLine();
        GameStateFacade gameStateFacade = gameStateConfiguration
                .gameStateFacade(initializeMap(Integer.parseInt(dimensions)), Integer.parseInt(dimensions),
                        Integer.parseInt(rowToWin));

        PositionReceiverFacade positionReceiverFacade = positionReceiverConfiguration.positionReceiverFacade(gameStateFacade);

        MapDrawerFacade mapDrawerFacade = mapDrawerConfiguration.MapDrawerFacadeFacade(gameStateFacade);
        PositionAIGeneratorFacade positionAIGeneratorFacade = positionAIGeneratorConfiguration.positionAIGeneratorFacade(gameStateFacade);
        ResultCheckerFacade resultCheckerFacade = resultCheckerConfiguration.positionReceiverFacade(gameStateFacade);


        while (true) {
//            clearConsole();
            mapDrawerFacade.printMap();
            System.out.println("Give me position of x");
            int x = Integer.parseInt(scanner.nextLine());
            System.out.println("Give me position of y");
            int y = Integer.parseInt(scanner.nextLine());
            PositionReceiverResultDto positionReceiverResultDto = positionReceiverFacade.inputPosition(new Position(x, y));
            if (positionReceiverResultDto.message().equals("positionIsEmpty everything works")) {
                ResultCheckerDto resultCheckerDto = resultCheckerFacade.checkWhoWin();

                if (!Objects.equals(resultCheckerDto.message(), "No one won")) {
                    boolean shouldGameBeFinished = printWhatIsHappenOnTheBoard(mapDrawerFacade, resultCheckerDto);
                    if (shouldGameBeFinished) {
                        return;
                    }
                }

                gameStateFacade.inputPosition(new PositionDto(x, y), 'X');
                PositionDto positionDto = positionAIGeneratorFacade.positionGenerator();
                gameStateFacade.inputPosition(positionDto, 'O');
                resultCheckerDto = resultCheckerFacade.checkWhoWin();

                if (!Objects.equals(resultCheckerDto.message(), "No one won")) {
                    boolean shouldGameBeFinished = printWhatIsHappenOnTheBoard(mapDrawerFacade, resultCheckerDto);
                    if (shouldGameBeFinished) {
                        return;
                    }
                }
            }

            if (gameStateFacade.isBoardFull()) {
                System.out.println("No one won");
                mapDrawerFacade.printMap();
                return;
            }
            System.out.println("No one won");
        }


    }

    private static boolean printWhatIsHappenOnTheBoard(MapDrawerFacade mapDrawerFacade, ResultCheckerDto resultCheckerDto) {
        if (resultCheckerDto.message().equals("User won")) {
//                    clearConsole();
            System.out.println("User won");
            mapDrawerFacade.printMap();
            return true;
        } else if (resultCheckerDto.message().equals("AI won")) {
//                    clearConsole();
            System.out.println("AI won");
            mapDrawerFacade.printMap();
            return true;
        }
        return false;
    }


    private static Map<PositionDto, Character> initializeMap(int size) {
        Map<PositionDto, Character> result = new HashMap<>();
        for (int j = 0; j < size; j++) {
            for (int i = 0; i < size; i++) {
                result.put(new PositionDto(j, i), '-');
            }
        }
        return result;
    }
////    public static void clearConsole() {
//        try {
//            final String os = System.getProperty("os.name");
//
//            if (os.contains("Windows")) {
//                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
//            } else {
//                Runtime.getRuntime().exec("clear");
//                System.out.print("\033[H\033[2J");
//                System.out.flush();
//            }
//        } catch (Exception e) {
//            // Obsłuż wyjątek, jeśli wystąpił błąd podczas czyszczenia konsoli
//            e.printStackTrace();
//        }
//    }
}
