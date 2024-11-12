package edu.grinnell.csc207.matrix;

import java.lang.reflect.Array;

/**
 * An implementation of two-dimensional matrices.
 *
 * @author Paden Houck
 * @author Samuel A. Rebelsky
 *
 * @param <T> The type of values stored in the matrix.
 */
public class MatrixV0<T> implements Matrix<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+
  T[][] contents;
  int defaultWidth;
  T defaultObject;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+
  /**
   * Create a new matrix of the specified width and height with the given value as the default.
   *
   * @param width The width of the matrix.
   * @param height The height of the matrix.
   * @param def The default value, used to fill all the cells.
   *
   * @throws NegativeArraySizeException If either the width or height are negative.
   */
  @SuppressWarnings("unchecked")
  public MatrixV0(int width, int height, T def) {
    this.defaultObject = def;
    this.defaultWidth = width;
    this.contents = (T[][]) Array.newInstance(Object.class, height, width);
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        this.contents[y][x] = this.defaultObject;
      } // for

    } // for
  } // MatrixV0(int, int, T)

  /**
   * Create a new matrix of the specified width and height with null as the default value.
   *
   * @param width The width of the matrix.
   * @param height The height of the matrix.
   *
   * @throws NegativeArraySizeException If either the width or height are negative.
   */
  public MatrixV0(int width, int height) {
    this(width, height, null);
  } // MatrixV0

  // +--------------+------------------------------------------------
  // | Core methods |
  // +--------------+

  /**
   * Get the element at the given row and column.
   *
   * @param row The row of the element.
   * @param col The column of the element.
   *
   * @return the value at the specified location.
   *
   * @throws IndexOutOfBoundsException If either the row or column is out of reasonable bounds.
   */
  public T get(int row, int col) {
    return contents[row][col];
  } // get(int, int)

  /**
   * Set the element at the given row and column.
   *
   * @param row The row of the element.
   * @param col The column of the element.
   * @param val The value to set.
   *
   * @throws IndexOutOfBoundsException If either the row or column is out of reasonable bounds.
   */
  public void set(int row, int col, T val) {
    contents[row][col] = val;
  } // set(int, int, T)

  /**
   * Determine the number of rows in the matrix.
   *
   * @return the number of rows.
   */
  public int height() {
    return contents.length;
  } // height()

  /**
   * Determine the number of columns in the matrix.
   *
   * @return the number of columns.
   */
  public int width() {
    if (contents.length > 0) {
      return contents[0].length;
    } else {
      return this.defaultWidth;
    } // else
  } // width()

  /**
   * Insert a row filled with the default value.
   *
   * @param row The number of the row to insert.
   *
   * @throws IndexOutOfBoundsException If the row is negative or greater than the height.
   */
  @SuppressWarnings("unchecked")
  public void insertRow(int row) {
    T[] vals = (T[]) Array.newInstance(Object.class, this.width());
    for (int i = 0; i < vals.length; i++) {
      vals[i] = this.defaultObject;
    } // vals
    try {
      this.insertRow(row, vals);
    } catch (ArraySizeException e) {
      e.printStackTrace();
    } // catch
  } // insertRow(int)

  /**
   * Insert a row filled with the specified values.
   *
   * @param row The number of the row to insert.
   * @param vals The values to insert.
   *
   * @throws IndexOutOfBoundsException If the row is negative or greater than the height.
   * @throws ArraySizeException If the size of vals is not the same as the width of the matrix.
   */
  @SuppressWarnings("unchecked")
  public void insertRow(int row, T[] vals) throws ArraySizeException {
    if (vals.length != this.width()) {
      throw new ArraySizeException();
    } // if
    T[][] tempContents = (T[][]) Array.newInstance(Object.class, this.height() + 1, this.width());

    for (int y = 0; y < this.height(); y++) {
      for (int x = 0; x < this.width(); x++) {
        if (y >= row) {
          tempContents[y + 1][x] = this.contents[y][x];
        } else {
          tempContents[y][x] = this.contents[y][x];
        } // else
      } // for
    } // for
    for (int x = 0; x < this.width(); x++) {
      tempContents[row][x] = vals[x];
    } // for
    this.contents = tempContents;
  } // insertRow(int, T[])

  /**
   * Insert a column filled with the default value.
   *
   * @param col The number of the column to insert.
   *
   * @throws IndexOutOfBoundsException If the column is negative or greater than the width.
   */
  @SuppressWarnings("unchecked")
  public void insertCol(int col) {
    T[] vals = (T[]) Array.newInstance(Object.class, this.height());
    for (int i = 0; i < vals.length; i++) {
      vals[i] = this.defaultObject;
    } // for
    try {
      this.insertCol(col, vals);
    } catch (ArraySizeException e) {
      e.printStackTrace();
    } // catch
  } // insertCol(int)

  /**
   * Insert a column filled with the specified values.
   *
   * @param col The number of the column to insert.
   * @param vals The values to insert.
   *
   * @throws IndexOutOfBoundsException If the column is negative or greater than the width.
   * @throws ArraySizeException If the size of vals is not the same as the height of the matrix.
   */
  @SuppressWarnings("unchecked")
  public void insertCol(int col, T[] vals) throws ArraySizeException {
    if (vals.length != this.height()) {
      throw new ArraySizeException();
    } // if
    T[][] tempContents = (T[][]) Array.newInstance(Object.class, this.height(), this.width() + 1);

    for (int y = 0; y < this.height(); y++) {
      for (int x = 0; x < this.width(); x++) {
        if (x >= col) {
          tempContents[y][x + 1] = this.contents[y][x];
        } else {
          tempContents[y][x] = this.contents[y][x];
        } // else
      } // if
    } // for
    for (int y = 0; y < this.height(); y++) {
      tempContents[y][col] = vals[y];
    } // for
    this.contents = tempContents;
  } // insertCol(int, T[])

  /**
   * Delete a row.
   *
   * @param row The number of the row to delete.
   *
   * @throws IndexOutOfBoundsException If the row is negative or greater than or equal to the
   *         height.
   */
  @SuppressWarnings("unchecked")
  public void deleteRow(int row) {

    T[][] tempContents = (T[][]) Array.newInstance(Object.class, this.height() - 1, this.width());

    for (int y = 0; y < this.height(); y++) {
      for (int x = 0; x < this.width(); x++) {
        if (y == row) {
        } else if (y > row) {
          tempContents[y - 1][x] = this.contents[y][x];
        } else {
          tempContents[y][x] = this.contents[y][x];
        } // else
      } // for
    } // for
    this.contents = tempContents;
  } // deleteRow(int)

  /**
   * Delete a column.
   *
   * @param col The number of the column to delete.
   *
   * @throws IndexOutOfBoundsException If the column is negative or greater than or equal to the
   *         width.
   */
  @SuppressWarnings("unchecked")
  public void deleteCol(int col) {

    T[][] tempContents = (T[][]) Array.newInstance(Object.class, this.height(), this.width() - 1);

    for (int y = 0; y < this.height(); y++) {
      for (int x = 0; x < this.width(); x++) {
        if (x == col) {
        } else if (x > col) {
          tempContents[y][x - 1] = this.contents[y][x];
        } else {
          tempContents[y][x] = this.contents[y][x];
        } // else
      } // for
    } // for
    this.contents = tempContents;
  } // deleteCol(int)

  /**
   * Fill a rectangular region of the matrix.
   *
   * @param startRow The top edge / row to start with (inclusive).
   * @param startCol The left edge / column to start with (inclusive).
   * @param endRow The bottom edge / row to stop with (exclusive).
   * @param endCol The right edge / column to stop with (exclusive).
   * @param val The value to store.
   *
   * @throw IndexOutOfBoundsException If the rows or columns are inappropriate.
   */
  public void fillRegion(int startRow, int startCol, int endRow, int endCol, T val) {
    for (int y = 0; y < this.height(); y++) {
      for (int x = 0; x < this.width(); x++) {
        if (x >= startCol && x < endCol && y >= startRow && y < endRow) {
          contents[y][x] = val;
        } // if
      } // for
    } // for
  } // fillRegion(int, int, int, int, T)

  /**
   * Fill a line (horizontal, vertical, diagonal).
   *
   * @param startRow The row to start with (inclusive).
   * @param startCol The column to start with (inclusive).
   * @param deltaRow How much to change the row in each step.
   * @param deltaCol How much to change the column in each step.
   * @param endRow The row to stop with (exclusive).
   * @param endCol The column to stop with (exclusive).
   * @param val The value to store.
   *
   * @throw IndexOutOfBoundsException If the rows or columns are inappropriate.
   */
  public void fillLine(int startRow, int startCol, int deltaRow, int deltaCol, int endRow,
      int endCol, T val) {
    int lineX = startCol;
    int lineY = startRow;
    while (lineX < endCol && lineY < endRow) {
      contents[lineY][lineX] = val;
      lineX += deltaCol;
      lineY += deltaRow;
    } // while
  } // fillLine(int, int, int, int, int, int, T)

  /**
   * A make a copy of the matrix. May share references (e.g., if individual elements are mutable,
   * mutating them in one matrix may affect the other matrix) or may not.
   *
   * @return a copy of the matrix.
   */
  public Matrix clone() {
    MatrixV0<T> temp = new MatrixV0<>(this.width(), this.height(), this.defaultObject);
    for (int y = 0; y < this.height(); y++) {
      for (int x = 0; x < this.width(); x++) {
        temp.set(y, x, defaultObject);
      } // for
    } // for

    return this;
  } // clone()

  /**
   * Determine if this object is equal to another object.
   *
   * @param other The object to compare.
   *
   * @return true if the other object is a matrix with the same width, height, and equal elements;
   *         false otherwise.
   */
  public boolean equals(Object other) {
    if (!(other instanceof MatrixV0)) {
      return false;
    } // if
    Matrix<T> cast = (MatrixV0<T>) other;
    if (this.height() != cast.height()) {
      return false;
    } // if
    if (this.width() != cast.width()) {
      return false;
    } // if
    for (int y = 0; y < this.height(); y++) {
      for (int x = 0; x < this.width(); x++) {
        if (get(y, x) == null) {
          if (!(cast.get(y, x) == null)) {
            return false;
          } // if
        } else {
          if (!get(y, x).equals(cast.get(y, x))) {
            return false;
          } // if
        } // else
      } // for
    } // for
    return true;
  } // equals(Object)

  /**
   * Compute a hash code for this matrix. Included because any object that implements `equals` is
   * expected to implement `hashCode` and ensure that the hash codes for two equal objects are the
   * same.
   *
   * @return the hash code.
   */
  public int hashCode() {
    int multiplier = 7;
    int code = this.width() + multiplier * this.height();
    for (int row = 0; row < this.height(); row++) {
      for (int col = 0; col < this.width(); col++) {
        T val = this.get(row, col);
        if (val != null) {
          // It's okay if the following computation overflows, since
          // it will overflow uniformly.
          code = code * multiplier + val.hashCode();
        } // if
      } // for col
    } // for row
    return code;
  } // hashCode()
} // class MatrixV0
