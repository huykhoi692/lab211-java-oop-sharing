@echo off
setlocal
set BASE=E:\FPTSubs\LAB\lab211-java-oop-sharing

:: ── J1.S.P0009 ──────────────────────────────────────────────────────────────
set P=%BASE%\J1.S.P0009\J1.S.P0009
if not exist "%P%\build\classes" mkdir "%P%\build\classes"
javac -d "%P%\build\classes" "%P%\src\ui\Main.java" 2>&1
if errorlevel 1 (echo J1.S.P0009: FAILED) else (echo J1.S.P0009: OK)

:: ── J1.S.P0052 ──────────────────────────────────────────────────────────────
set P=%BASE%\J1.S.P0052\J1.S.P0052
if not exist "%P%\build\classes" mkdir "%P%\build\classes"
javac -sourcepath "%P%\src" -d "%P%\build\classes" ^
  "%P%\src\util\Validation.java" ^
  "%P%\src\entity\Country.java" ^
  "%P%\src\entity\EastAsiaCountry.java" ^
  "%P%\src\bo\CountryManager.java" ^
  "%P%\src\controller\CountryController.java" ^
  "%P%\src\ui\Main.java" 2>&1
if errorlevel 1 (echo J1.S.P0052: FAILED) else (echo J1.S.P0052: OK)

:: ── J1.S.P0056 ──────────────────────────────────────────────────────────────
set P=%BASE%\J1.S.P0056\J1.S.P0056
if not exist "%P%\build\classes" mkdir "%P%\build\classes"
javac -sourcepath "%P%\src" -d "%P%\build\classes" ^
  "%P%\src\util\Validation.java" ^
  "%P%\src\entity\Worker.java" ^
  "%P%\src\entity\SalaryHistory.java" ^
  "%P%\src\bo\WorkerManager.java" ^
  "%P%\src\controller\WorkerController.java" ^
  "%P%\src\ui\Main.java" 2>&1
if errorlevel 1 (echo J1.S.P0056: FAILED) else (echo J1.S.P0056: OK)

:: ── J1.S.P0061 ──────────────────────────────────────────────────────────────
set P=%BASE%\J1.S.P0061\J1.S.P0061
if not exist "%P%\build\classes" mkdir "%P%\build\classes"
javac -sourcepath "%P%\src" -d "%P%\build\classes" ^
  "%P%\src\util\Validation.java" ^
  "%P%\src\entity\Shape.java" ^
  "%P%\src\entity\Rectangle.java" ^
  "%P%\src\entity\Circle.java" ^
  "%P%\src\entity\Triangle.java" ^
  "%P%\src\controller\ShapeController.java" ^
  "%P%\src\ui\Main.java" 2>&1
if errorlevel 1 (echo J1.S.P0061: FAILED) else (echo J1.S.P0061: OK)

:: ── J1.S.P0063 ──────────────────────────────────────────────────────────────
set P=%BASE%\J1.S.P0063\J1.S.P0063
if not exist "%P%\build\classes" mkdir "%P%\build\classes"
javac -sourcepath "%P%\src" -d "%P%\build\classes" ^
  "%P%\src\util\Validation.java" ^
  "%P%\src\entity\Person.java" ^
  "%P%\src\bo\PersonManager.java" ^
  "%P%\src\controller\PersonController.java" ^
  "%P%\src\ui\Main.java" 2>&1
if errorlevel 1 (echo J1.S.P0063: FAILED) else (echo J1.S.P0063: OK)

:: ── J1.S.P0072 ──────────────────────────────────────────────────────────────
set P=%BASE%\J1.S.P0072\J1.S.P0072
if not exist "%P%\build\classes" mkdir "%P%\build\classes"
javac -sourcepath "%P%\src" -d "%P%\build\classes" ^
  "%P%\src\util\Validation.java" ^
  "%P%\src\entity\Account.java" ^
  "%P%\src\bo\AccountManager.java" ^
  "%P%\src\controller\LoginController.java" ^
  "%P%\src\ui\Main.java" 2>&1
if errorlevel 1 (echo J1.S.P0072: FAILED) else (echo J1.S.P0072: OK)

endlocal

