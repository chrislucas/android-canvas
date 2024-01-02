package com.br.experience.features.book.android2dgraphics.chp2

import kotlin.math.atan2
import kotlin.math.sqrt

/**
 * O sistema de coordenada de dispositivo tem sua ORIGEM no canto superior esquerdo da tela
 * Assim o ponto (0, 0) está lá.
 *
 * Estamos acostumados com o sistema de coordenada cartesiano, onde o eixo X positivamente
 * do ponto de origem se afastando para a direita e negativamente quando se afasta para esquerda
 * e o ponto Y passa a ser positivo quando se afasta para cima e negativo para baixo. Entretanto,
 * no sistema de coordenadas de dispostivo não temos um valor de X e Y negativo, aumentar o valor
 * de X desloca o objeto para direita e aumentar o valor de Y desloca para baixo.
 *
 * Com um pouco de lógica e matemática podemos inverter as coordenadas de dispostivo para trabalhar
 * de uma forma cartesiana, por exemplo
 *
 * Imagina uma tela de 500 x 500 px,podemos fazer co que o centro dessa tela seja a nossa origem
 * O(250, 250).
 *
 * - Se quisermos desenhar um pixel no ponto
 * (-3, 3), sabendo que para desenhar para baixo do ponto de origem precisamos aumentar o valor de
 * Y entao o ponto na tela que temos que desenhar é o ponto (253, 253).
 *
 * - Se quisermos desenha um pixel no ponto (3, 3), o pixel será desenhado no ponto (247, 253)
 *
 * - Veja que quando queremos desenhar para cima do ponto de origem precisamos subtrair, e se quisermos
 * desenha para baixo precisamos adicionar.
 *
 */

class CoordinateSystem(private val originRef: Pair<Double, Double>) {
    /**
     * Device or display coordinate system
     * - "display computers, cell phones, tablets are RASTER DEVICES. The term raster device
     * means a device that is composed of discrete pixels."
     *
     * - Coordinate system is dependent of device because the maximum values of x and y are
     * related to the resolution of device
     *
     * Logical Coordinate System
     * - Is a device-independent coordinate system defined by a programmer for a particular
     * task.
     *
     * - Usually it is a Cartesian coordinate system
     * - Can uses some logical units of distance
     * - Horizontal and vertical axes can have either the same o different units.
     *      - Example is a stock market it can uses DAYS as horizontal axis units and
     *      STOCK PRICE  as vertical axis
     *
     * Global amd Local Coordinate System
     * - Many OS can display multiples windows on screens. Each window uses local coordinate
     * system to display its content
     * -Then OS converts local window coordinates to global screen coordinate
     */

    /**
     * Numa tela de 800x1200 posso deslocar minha origem para o centro dela, P(400, 600)
     * sendo P o ponto de Origem O(0, 0) agora
     */
    fun toCoordinateSystem(point: Pair<Double, Double>): Pair<Double, Double> {
        return Pair(originRef.first + point.first, originRef.second + point.second)
    }

    fun toCartesianSystem(point: Pair<Double, Double>): Pair<Double, Double> {
        return Pair(originRef.first - point.first, originRef.second - point.second)
    }

    fun Pair<Double, Double>.toPolarCoordinate(): Pair<Double, Double> =
        let { (x, y) ->
            Pair(sqrt(x * x + y * y), atan2(y, x))
        }
}

